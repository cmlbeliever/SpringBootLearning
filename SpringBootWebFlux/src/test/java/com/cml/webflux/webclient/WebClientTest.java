package com.cml.webflux.webclient;

import com.cml.learn.webflux.controller.WebFluxController;
import io.netty.channel.ChannelOption;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.*;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: cml
 * @Date: 2019-01-28 13:38
 * @Description:
 */
public class WebClientTest {
    private WebTestClient client;


    @Before
    public void setUp() {
        client = WebTestClient.bindToController(new TestController()).build();
        ReactorClientHttpConnector reactorClientHttpConnector = new ReactorClientHttpConnector(t -> {
            t.option(ChannelOption.SO_TIMEOUT, 10_000);
        });
        WebClient webClient = WebClient.builder().filter((reqeust, next) -> {
            return next.exchange(reqeust);
        }).baseUrl("https://www.baidu.com").clientConnector(reactorClientHttpConnector).build();
    }

    @Test
    public void simpleTest() {
        Map param = new HashMap();
        param.put("name", "test1Name");
        client.post().uri("/testNamePost1", param)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody().consumeWith(t -> {
            String result = new String(t.getResponseBody());
            System.out.println(result);
        });
    }

    @Test
    public void simpleTest2() {
        Map param = new HashMap();
        param.put("name", "test1Name");
        client.post().uri("/testNamePost")
                .syncBody(param)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody().consumeWith(t -> {
            String result = new String(t.getResponseBody());
            System.out.println(result);
        });


    }

    @RestController
    static class TestController {

        @RequestMapping("/testName")
        public String handle(@RequestParam() String name) {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
            return "Hello " + name + "!";
        }

        @PostMapping("/testNamePost")
        public Mono<String> handlePost(@RequestBody Map param) {
            System.out.println("handlePost=====");
            return Mono.just("Hello " + param + "!");
        }

        @PostMapping("/testNamePost1")
        public Mono<String> handlePost1() {
            System.out.println("handlePost=====");
            return Mono.just("Hello !");
        }
    }

}
