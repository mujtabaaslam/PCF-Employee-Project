package com.example.companybase.employeesui;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EmployeesInitialList {

    public List<EmployeeUI> asList(){
        return Arrays.asList(new EmployeeUI("Zezhi", "Xia", "zezhi.xia@perficient.com", 80000, "Technical Consultant", "CSP"),
                new EmployeeUI("first", "name", "first.name@perficient.com", 12, "Technical Consultant", "CSP"));
    }

}
