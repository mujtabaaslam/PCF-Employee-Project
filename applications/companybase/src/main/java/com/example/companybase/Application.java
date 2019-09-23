package com.example.companybase;

import com.example.companybase.clients.ClientActionServlet;
import com.example.companybase.employeesui.EmployeeActionServlet;
import com.example.companybase.employeesui.EmployeeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    @Value("${employees.ms.url")
    private String employeesURL;

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

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public EmployeeClient employeeClient(RestOperations restOperations) {
        return new EmployeeClient(employeesURL, restOperations);
    }
}
