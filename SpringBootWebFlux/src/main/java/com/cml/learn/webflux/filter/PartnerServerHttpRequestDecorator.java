package com.cml.learn.webflux.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import reactor.core.publisher.Flux;

import java.util.Optional;
import java.util.stream.Collectors;

import static reactor.core.scheduler.Schedulers.single;

public class PartnerServerHttpRequestDecorator extends ServerHttpRequestDecorator {

    private Logger log = LoggerFactory.getLogger(getClass());

    private Flux<DataBuffer> body;

    PartnerServerHttpRequestDecorator(ServerHttpRequest delegate) {
        super(delegate);
        final String path = delegate.getURI().getPath();
        final String query = delegate.getURI().getQuery();
        final String method = Optional.ofNullable(delegate.getMethod()).orElse(HttpMethod.GET).name();
        final String headers = delegate.getHeaders().entrySet()
                .stream()
                .map(entry -> "            " + entry.getKey() + ": [" + String.join(";", entry.getValue()) + "]")
                .collect(Collectors.joining("\n"));
        final MediaType contentType = delegate.getHeaders().getContentType();
        if (log.isDebugEnabled()) {
            log.debug("\n" +
                    "HttpMethod : {}\n" +
                    "Uri        : {}\n" +
                    "Headers    : \n" +
                    "{}", method, path + (StringUtils.isEmpty(query) ? "" : "?" + query), headers);
        }
        Flux<DataBuffer> flux = super.getBody();
        body = flux.map(dataBuffer -> LogUtils.loggingRequest(log, dataBuffer));
        body.subscribe();
    }

    @Override
    public Flux<DataBuffer> getBody() {
        return body;
    }

}