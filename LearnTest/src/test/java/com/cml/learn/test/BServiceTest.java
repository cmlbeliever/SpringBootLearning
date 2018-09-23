package com.cml.learn.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BService.class)
public class BServiceTest {

    @Autowired
    private BService bService;

    @Test
    public void testDoSmthin() {
        String smthing = bService.doSmthing();
        System.out.println("===============>" + smthing);
        Assert.assertTrue(smthing != null);
    }
}
