package com.cml.learn.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        AService.class
})
public class AServiceMockTest {
    @Autowired
    private AService aService;
    @MockBean
    private BService bService;
    @MockBean
    private CService cService;

    @Before
    public void setUp() {
        Mockito.when(bService.doSmthing()).thenReturn("mockBServce");
        Mockito.when(cService.doSmthing()).thenReturn("mockCServce");
    }

    @Test
    public void test() {
        aService.doSmthing();
    }

}
