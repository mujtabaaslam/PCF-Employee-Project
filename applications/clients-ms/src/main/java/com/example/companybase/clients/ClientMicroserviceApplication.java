package com.example.companybase.clients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ClientMicroserviceApplication {

    public static void main(String... args) {
        SpringApplication.run(ClientMicroserviceApplication.class, args);
    }
}
