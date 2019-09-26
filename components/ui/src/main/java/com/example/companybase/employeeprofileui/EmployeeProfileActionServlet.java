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
    public String findProfile(Map<String, Object> model,
                              @RequestParam("id") long id,
                              @RequestParam("fn") String firstName,
                              @RequestParam("ln") String lastName,
                              @RequestParam("e") String email,
                              @RequestParam("s") String salary,
                              @RequestParam("t") String title,
                              @RequestParam("d") String department) {
        model.put("employeeprofile", employeeProfileClient.find(id));
        model.put("firstName", firstName);
        model.put("lastName", lastName);
        model.put("email", email);
        model.put("salary", salary);
        model.put("title", title);
        model.put("department", department);
        return "profile";
    }

}
