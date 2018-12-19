package com.cml.learn.webflux.filter;

import org.slf4j.LoggerFactory;
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

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        final ServerWebExchange ex = new PayloadServerWebExchangeDecorator(exchange);
        return chain.filter(ex).doOnError(t -> {
            logger.info("onError:" + t);
        }).doOnSuccess(t -> {
            logger.info("success:" + t);
        }).doFinally(t -> {
            logger.info("finally-->" + ((PartnerServerHttpResponseDecorator) ex.getResponse()).getBody());
        });
    }
}
