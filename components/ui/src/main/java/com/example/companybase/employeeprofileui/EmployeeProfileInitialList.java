package com.example.companybase.employeeprofileui;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProfileInitialList {

    public List<EmployeeProfileUI> asList(List<Long> ids){
        List<EmployeeProfileUI> list = new ArrayList<>();
        list.add(new EmployeeProfileUI(ids.get(0), "a", "b", "c"));
        list.add(new EmployeeProfileUI(ids.get(1), "d", "ee", "f"));
        return list;
    }
}
