package com.cml.learn.webflux.error;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.NettyDataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @Auther: cml
 * @Date: 2018-12-19 10:17
 * @Description:
 */
//@Component
public class ErrorHandler extends AbstractErrorWebExceptionHandler {
    public ErrorHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, applicationContext);
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::handleException);
    }

    private Mono<ServerResponse> handleException(ServerRequest request) {
        Map<String, Object> errorPropertiesMap = getErrorAttributes(request, false);
        errorPropertiesMap.put("error", "报错啦");

        return ServerResponse.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(errorPropertiesMap));
    }

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
