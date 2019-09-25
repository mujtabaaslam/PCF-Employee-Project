package com.example.companybase.employeeprofileui;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.List;

public class EmployeeProfileClient {

    private static ParameterizedTypeReference<List<EmployeeProfileUI>> employeeProfileListType = new ParameterizedTypeReference<List<EmployeeProfileUI>>() {
    };
    private RestOperations restOperations;
    private String employeesProfileURL;


    public EmployeeProfileClient(String employeesProfileURL, RestOperations restOperations) {
        this.restOperations = restOperations;
        this.employeesProfileURL = employeesProfileURL;
    }

    public void create(EmployeeProfileUI employeeProfileUI) {
        restOperations.postForEntity(employeesProfileURL, employeeProfileUI, EmployeeProfileUI.class);
    }

    public EmployeeProfileUI find(Long id) {
        String findURL = new StringBuilder(employeesProfileURL).append("/").append(id).toString();
        EmployeeProfileUI read = restOperations.getForEntity(findURL, EmployeeProfileUI.class).getBody();
        return read;
    }

    public List<EmployeeProfileUI> findAll() {
        return restOperations.exchange(employeesProfileURL, HttpMethod.GET, null, employeeProfileListType).getBody();
    }

}
