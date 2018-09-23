package com.cml.learn.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DService {
    @Value("${config.username}")
    private String username;

    public String doSmthing() {
        return username+" doSmthing";
    }
}
