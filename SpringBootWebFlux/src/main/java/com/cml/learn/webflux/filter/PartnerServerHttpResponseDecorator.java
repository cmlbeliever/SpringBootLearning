package com.cml.learn.webflux.filter;

import org.apache.commons.io.IOUtils;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

public class PartnerServerHttpResponseDecorator extends ServerHttpResponseDecorator {
    private Logger log = LoggerFactory.getLogger(getClass());
    private String body;

    PartnerServerHttpResponseDecorator(ServerHttpResponse delegate) {
        super(delegate);
    }

    @Override
    public Mono<Void> writeAndFlushWith(Publisher<? extends Publisher<? extends DataBuffer>> body) {
        return super.writeAndFlushWith(body);
    }

    @Override
    public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
//        final MediaType contentType = super.getHeaders().getContentType();
        if (body instanceof Mono) {
            final Mono<DataBuffer> monoBody = (Mono<DataBuffer>) body;
            return super.writeWith(monoBody.map(t -> {
                System.out.println("================save==============");
                save(t);
                t.readPosition(0);
                return t;
            }));
//            return super.writeWith(monoBody.publishOn(single()).map(dataBuffer -> LogUtils.loggingResponse(log, dataBuffer)));
        } else if (body instanceof Flux) {
            final Flux<DataBuffer> monoBody = (Flux<DataBuffer>) body;
//            return super.writeWith(monoBody.publishOn(single()).map(dataBuffer -> LogUtils.loggingResponse(log, dataBuffer)));
        }
        return super.writeWith(body);
    }

    private void save(DataBuffer t) {
        try {
            body = IOUtils.toString(t.asInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBody() {
        return body;
    }
}