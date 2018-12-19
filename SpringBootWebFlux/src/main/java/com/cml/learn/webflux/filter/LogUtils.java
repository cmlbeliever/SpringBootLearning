package com.cml.learn.webflux.filter;

import io.netty.buffer.UnpooledByteBufAllocator;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class LogUtils {

    public static final List<MediaType> legalLogMediaTypes = Arrays.asList(MediaType.TEXT_XML,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_JSON_UTF8,
            MediaType.TEXT_PLAIN,
            MediaType.TEXT_XML);

    @SuppressWarnings("unchecked")
    public static <T extends DataBuffer> T loggingRequest(Logger log, T buffer) {
        return logging(log, ">>>>>>>>>>", buffer);
    }

    public static <T extends DataBuffer> T loggingResponse(Logger log, T buffer) {
        return logging(log, "<<<<<<<<<<", buffer);
    }

    private static <T extends DataBuffer> T logging(Logger log, String inOrOut, T buffer) {
        try {
            InputStream dataBuffer = buffer.asInputStream();
            byte[] bytes = IOUtils.toByteArray(dataBuffer);
            NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(new UnpooledByteBufAllocator(false));
            if (log.isDebugEnabled()) {
                log.debug("\n" +
                        "{}Payload    : {}", inOrOut, new String(bytes));
            }
            DataBufferUtils.release(buffer);
            return (T) nettyDataBufferFactory.wrap(bytes);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}