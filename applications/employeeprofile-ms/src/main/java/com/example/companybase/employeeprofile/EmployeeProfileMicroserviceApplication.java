package com.example.companybase.employeeprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EmployeeProfileMicroserviceApplication {
    public static void main(String... args) {
        SpringApplication.run(EmployeeProfileMicroserviceApplication.class, args);
    }

}
