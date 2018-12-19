package com.cml.learn.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/webflux")
public class WebFluxController {

    @GetMapping("/test1")
    public Mono<String> test1(@RequestParam String name) {
        return Mono.just("result:" + name);
    }

    @GetMapping("/testError")
    public Mono<String> testError() {
        System.out.println("error==>");
        throw new IllegalArgumentException("xxxx");
    }

    @GetMapping("/testList")
    public Flux<String> testList(@RequestParam String name) {
        return Flux.just(name.split(","));
    }

    /**
     * 页面耗时5s后才能获取到结果
     *
     * @param name
     * @return
     */
    @GetMapping("/testLongTime")
    public Flux<String> testLongTime(@RequestParam String name) {
        return Flux.create(t -> {
            IntStream.range(1, 50).forEach(v -> {
                t.next("value:" + v);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.complete();
        });
    }
}
