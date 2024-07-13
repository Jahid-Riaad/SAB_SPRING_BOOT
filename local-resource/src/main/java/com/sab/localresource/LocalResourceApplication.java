package com.sab.localresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@ComponentScan(basePackages = "com.sab")
public class LocalResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalResourceApplication.class, args);
        System.out.println("Hi there..");
    }

}
