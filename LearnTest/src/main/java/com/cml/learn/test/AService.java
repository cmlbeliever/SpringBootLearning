package com.cml.learn.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AService {

    private CService cService;
    private BService bService;

    @Autowired
    public AService(CService cService, BService bService) {
        this.cService = cService;
        this.bService = bService;
    }

    public void doSmthing() {
        System.out.println("AService doSmthing");
        System.out.println(bService.doSmthing());
        System.out.println(cService.doSmthing());
    }
}
