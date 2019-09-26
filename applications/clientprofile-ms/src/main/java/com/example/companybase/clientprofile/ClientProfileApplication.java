package com.example.companybase.clientprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ClientProfileApplication {
    public static void main(String... args) {
        SpringApplication.run(ClientProfileApplication.class, args);
    }
}
