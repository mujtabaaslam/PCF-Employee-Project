package com.example.companybase;

import com.example.companybase.clientprofileui.ClientProfileClient;
import com.example.companybase.employeeprofileui.EmployeeProfileClient;
import com.example.companybase.employeesui.EmployeeActionServlet;
import com.example.companybase.employeesui.EmployeeClient;
import com.example.companybase.clientsui.ClientActionServlet;
import com.example.companybase.clientsui.ClientClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean registerEmployeeActionServlet(EmployeeActionServlet actionServlet) {
        return new ServletRegistrationBean(actionServlet, "/employee/*");
    }

    @Bean
    public ServletRegistrationBean registerClientActionServlet(ClientActionServlet actionServlet) {
        return new ServletRegistrationBean(actionServlet, "/client/*");
    }

    @LoadBalanced
    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public EmployeeClient employeeClient(RestOperations restOperations) {
        return new EmployeeClient("//employees-ms/employees", restOperations);
    }
  
    @Bean
    public ClientClient clientClient(RestOperations restOperations) {
        return new ClientClient("//clients-ms/clients", restOperations);
    }

    @Bean
    public EmployeeProfileClient employeeProfileClient(RestOperations restOperations) {
        return new EmployeeProfileClient("//employeeprofile-ms/profile", restOperations);
    }

    @Bean
    public ClientProfileClient clientProfileClientProfileClient(RestOperations restOperations) {
        return new ClientProfileClient("//clientprofile-ms/clientprofile", restOperations);
    }
}
