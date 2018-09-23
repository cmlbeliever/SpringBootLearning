package com.cml.learn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        AService.class,
        BService.class,
        CService.class
})
public class AServiceTest {
    @Autowired
    private AService aService;


    @Test
    public void test() {
        aService.doSmthing();
    }

}
