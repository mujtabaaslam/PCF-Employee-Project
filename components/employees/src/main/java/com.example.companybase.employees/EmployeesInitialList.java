package com.example.companybase.employees;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EmployeesInitialList {

    public List<Employee> asList(){
        return Arrays.asList(new Employee("Zezhi", "Xia", "zezhi.xia@perficient.com", 80000, "Technical Consultant", "CSP"));
    }

}
