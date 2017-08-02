package com.example.spring.boot.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author mlahariya
 * @version 1.0, Nov 2016
 */

@SpringBootApplication
@ComponentScan("com.example.spring.boot.rest")
public class SpringBootGrandRestAdapterApplication {

    @Autowired
    @Qualifier("MessageSource")
    private ResourceBundleMessageSource messageSource;

    public static void main(String[] args) {

        System.out.println("Start");
        SpringApplication.run(SpringBootGrandRestAdapterApplication.class, args);
        System.out.println("End");

    }
}
