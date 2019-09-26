package com.example.companybase.employeeprofileui;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProfileInitialList {

    public List<EmployeeProfileUI> asList(List<Long> ids){
        List<EmployeeProfileUI> list = new ArrayList<>();
        int repeat = ids.size() / 10;
        for(int i = 0; i < repeat; i++) {
            list.add(new EmployeeProfileUI(ids.get(0 + (10 * i)), "Detroit, MI", "Java, Spring, Cloud Foundry", "Cloud Foundry"));
            list.add(new EmployeeProfileUI(ids.get(1 + (10 * i)), "Livonia, MI", "Java, C, Spring", "None"));
            list.add(new EmployeeProfileUI(ids.get(2 + (10 * i)), "Chicago, IL", "Agile, Microsoft Office", "None"));
            list.add(new EmployeeProfileUI(ids.get(3 + (10 * i)), "New York, NY", "Salesforce, Microsoft Excel", "Salesforce"));
            list.add(new EmployeeProfileUI(ids.get(4 + (10 * i)), "San Francisco, CA", "Management", "None"));
            list.add(new EmployeeProfileUI(ids.get(5 + (10 * i)), "Boston, MA", "Networking", "None"));
            list.add(new EmployeeProfileUI(ids.get(6 + (10 * i)), "Livonia, MI", "Java", "AWS"));
            list.add(new EmployeeProfileUI(ids.get(7 + (10 * i)), "San Diego, CA", "Java, C, Spring, Cloud Foundry", "Cloud Foundry"));
            list.add(new EmployeeProfileUI(ids.get(8 + (10 * i)), "Jersey City, NJ", "Team Management, Java, Spring", "None"));
            list.add(new EmployeeProfileUI(ids.get(9 + (10 * i)), "Livonia, MI", "Communication", "None"));
        }
        return list;
    }
}
