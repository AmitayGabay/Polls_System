package com.example.polls_system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class PollsSystemApplication {


    public static void main(String[] args) {
        SpringApplication.run(PollsSystemApplication.class, args);
    }
}
