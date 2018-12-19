package com.cml.learn.webflux.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @Auther: cml
 * @Date: 2018-12-19 09:48
 * @Description:
 */
@Component
public class AccessLogFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return chain.filter(exchange).doOnError(t -> {
            System.out.println("onError:" + t);
        }).doFinally(t -> {
            System.out.println("finally");
        });
    }
}
