package com.vega.springit.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class DatabaseLoder implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("database loader...");
    }

}
