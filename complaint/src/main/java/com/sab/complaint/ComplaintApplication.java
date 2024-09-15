package com.sab.complaint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ComplaintApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComplaintApplication.class, args);
    }

}
