package com.cml.learn.webflux.error;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.NettyDataBuffer;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * @Auther: cml
 * @Date: 2018-12-19 10:17
 * @Description:
 */
@Component
public class ErrorHandler implements WebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        System.out.println("-----------------------------------errorHandler------------------------" + ex.getMessage());
        if (exchange.getResponse().isCommitted()) {
            return Mono.error(ex);
        }
        return Mono.just(ex).flatMap(t -> {
            return Mono.empty();
        });
    }
}
