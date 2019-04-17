package com.cml.learn.test;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.hamcrest.MockitoHamcrest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MockSelectorTest {
    @Mock
    private AService aService;

    @Test
    public void testMock() {
        Mockito.when(aService.doSmthing2(Mockito.anyString())).thenReturn("mockValue");
        assert aService.doSmthing2("value").equals("mockValue");
    }

    @Test
    public void testSelector() {
        //默认返回
        Mockito.when(aService.doSmthing2(Mockito.any())).thenReturn("mockANYValue");
        Mockito.when(aService.doSmthing2(Mockito.argThat(arg -> "aa".equals(arg)))).thenReturn("mockAAAValue");
        Mockito.when(aService.doSmthing2(Mockito.argThat(arg -> "bb".equals(arg)))).thenReturn("mockBBBValue");

        assert "mockAAAValue".equals(aService.doSmthing2("aa"));
        assert "mockBBBValue".equals(aService.doSmthing2("bb"));
        assert "mockANYValue".equals(aService.doSmthing2("cc"));
        assert "mockANYValue".equals(aService.doSmthing2(null));
    }

    @Test
    public void testSelectorMockitoHamcrest() {
        //默认返回
        Mockito.when(aService.doSmthing2(Mockito.any())).thenReturn("mockANYValue");
        Mockito.when(aService.doSmthing2(MockitoHamcrest.argThat(new BaseMatcher<String>() {
            @Override
            public boolean matches(Object item) {
                return "aa".equals(item);
            }

            @Override
            public void describeTo(Description description) {

            }
        }))).thenReturn("mockAAAValue");
        Mockito.when(aService.doSmthing2(MockitoHamcrest.argThat(new BaseMatcher<String>() {
            @Override
            public boolean matches(Object item) {
                return "bb".equals(item);
            }

            @Override
            public void describeTo(Description description) {

            }
        }))).thenReturn("mockBBBValue");

        assert "mockAAAValue".equals(aService.doSmthing2("aa"));
        assert "mockBBBValue".equals(aService.doSmthing2("bb"));
        assert "mockANYValue".equals(aService.doSmthing2("cc"));
        assert "mockANYValue".equals(aService.doSmthing2(null));
    }
}
