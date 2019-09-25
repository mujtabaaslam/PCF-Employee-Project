package com.example.companybase.employeeprofileui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class EmployeeProfileActionServlet{

    private EmployeeProfileClient employeeProfileClient;

    public EmployeeProfileActionServlet(EmployeeProfileClient employeeProfileClient) {
        this.employeeProfileClient = employeeProfileClient;
    }

    @GetMapping("/profile")
    public String findProfile(Map<String, Object> model, @RequestParam("id") long id) {
        model.put("employeeprofile", employeeProfileClient.find(id));
        return "profile";
    }

}
