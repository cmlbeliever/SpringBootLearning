package com.cml.webflux.webclient;

import java.net.URI;

import org.junit.Test;
import reactor.core.publisher.Flux;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hamcrest.Matchers.*;

/**
 * Samples of tests using {@link WebTestClient} with serialized JSON content.
 *
 * @author Rossen Stoyanchev
 * @author Sam Brannen
 * @since 5.0
 */
public class JsonContentTests {

    private final WebTestClient client = WebTestClient.bindToController(new PersonController()).build();


    @Test
    public void jsonContent() {
        this.client.get().uri("/persons")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void jsonPathIsEqualTo() {
        this.client.get().uri("/persons")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].name").isEqualTo("Jane")
                .jsonPath("$[1].name").isEqualTo("Jason")
                .jsonPath("$[2].name").isEqualTo("John");
    }


    @Test
    public void postJsonContent() {
        this.client.post().uri("/persons")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody("{\"name\":\"John\"}")
                .exchange()
                .expectStatus().isCreated()
                .expectBody().isEmpty();
    }


    @RestController
    @RequestMapping("/persons")
    static class PersonController {

        @GetMapping
        Flux<Person> getPersons() {
            System.out.println("persons=============");
            return Flux.just(new Person("Jane"), new Person("Jason"), new Person("John"));
        }

        @GetMapping("/{name}")
        Person getPerson(@PathVariable String name) {
            return new Person(name);
        }

        @PostMapping
        ResponseEntity<String> savePerson(@RequestBody Person person) {
            return ResponseEntity.created(URI.create("/persons/" + person.getName())).build();
        }
    }

}