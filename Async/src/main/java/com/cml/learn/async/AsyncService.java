package com.cml.learn.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

@Component
public class AsyncService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private List<Long> threadIdList = new ArrayList<>();

    @Async
    public void testAsyncException(int index) {
        throw new RuntimeException("测试异常" + index);
    }

    @Async
    public void testAsync(int index) {
        logger.info("ThreadId:{},ThreadName:{},index:{}", Thread.currentThread().getId(), Thread.currentThread().getName(), index);
        addThreadQuene(index);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (index == 10) {
            throw new RuntimeException("测试异常");
        }
    }

    @Async
    public Future<String> testFuture(int index) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return AsyncResult.forValue("FutureTask:" + index);
    }

    @Async
    public CompletableFuture<String> testCompletableFuture(int index) {
        return CompletableFuture.completedFuture("testCompletableFuture:" + index);
    }


    @Async
    public ListenableFuture<String> testLisenableAsync(int index) {
        if (index == 10)
            throw new RuntimeException("testLisenableAsync:" + index);
        return AsyncResult.forValue("testValue:" + index + ",threadId:" + Thread.currentThread().getId());
    }

    private synchronized void addThreadQuene(int index) {
        long id = Thread.currentThread().getId();
        if (threadIdList.contains(id)) {
            logger.info("----------->线程重用：{},index:{}", id, index);
        } else {
            threadIdList.add(id);
        }
    }

    public List<Long> getThreadIdList() {
        return threadIdList;
    }
}
