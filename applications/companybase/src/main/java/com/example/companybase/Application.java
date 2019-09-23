package com.example.companybase;

import com.example.companybase.clients.ClientActionServlet;
import com.example.companybase.employees.EmployeeActionServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

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
}
