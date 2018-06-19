package com.cml.learn.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AsyncService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private List<Long> threadIdList = new ArrayList<>();

    @Async
    public void testAsync(int index) {
        logger.info("ThreadId:{},ThreadName:{},index:{}", Thread.currentThread().getId(), Thread.currentThread().getName(), index);
        addThreadQuene(index);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
