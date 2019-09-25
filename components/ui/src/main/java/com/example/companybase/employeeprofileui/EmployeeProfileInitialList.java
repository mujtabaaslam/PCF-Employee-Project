package com.example.companybase.employeeprofileui;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProfileInitialList {

    public List<EmployeeProfileUI> asList(List<Long> ids){
        List<EmployeeProfileUI> list = new ArrayList<>();
        long id = ids.get(0);
        list.add(new EmployeeProfileUI(id, "a", "b", "c"));
        return list;
    }
}
