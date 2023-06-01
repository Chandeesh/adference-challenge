package com.adference.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
 

@SpringBootApplication
@ComponentScan(basePackages = "com.adference.*")
public class ChallengeApp {
 
    public static void main(String[] args) {
        SpringApplication.run(ChallengeApp.class, args);
    }
}