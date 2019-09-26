package com.example.companybase.employeesui;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EmployeesInitialList {

    public List<EmployeeUI> asList(){
        return Arrays.asList(new EmployeeUI("Zezhi", "Xia", "zezhi.xia@example.com", 20, "Technical Consultant", "CPS"),
                new EmployeeUI("Mujtaba", "Aslam", "Mujtaba.Aslam@example.com", 12, "Technical Consultant", "CPS"),
                new EmployeeUI("John", "Smith", "John.Smith@example.com", 25, "Business Consultant", "Business"),
                new EmployeeUI("Mark", "Adams", "Mark.Adams@example.com", 50, "Sales Manager", "Sales"),
                new EmployeeUI("Jacob", "Freeman", "Jacob.Freeman@example.com", 75, "HR Manager", "HR"),
                new EmployeeUI("Benny", "York", "Benny.York@example.com", 85, "Recruiter", "HR"),
                new EmployeeUI("Madina", "Bishop", "Madina.Bishop@example.com", 58, "Associate Consultant", "Business"),
                new EmployeeUI("Jeff", "Philips", "Jeff.Philips@example.com", 100, "Technical Lead", "CPS"),
                new EmployeeUI("Montana", "Bannister", "Montana.Bannister@example.com", 150, "Team Director", "Business"),
                new EmployeeUI("Hari", "White", "Hari.White@example.com", 43, "Lawyer", "Legal")
                );
    }

}
