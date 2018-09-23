package com.cml.learn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        DService.class,
        PropertySourcesPlaceholderConfigurer.class
})
@TestPropertySource("classpath:application.properties")
public class DServicePropertiesFileTest {
    @Autowired
    private DService dService;

    @Test
    public void test() {
        String result = dService.doSmthing();
        System.out.println(result);
    }
}
