package com.example.companybase.clientprofileui;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.List;

public class ClientProfileClient {

    private static ParameterizedTypeReference<List<ClientProfileUI>> employeeProfileListType = new ParameterizedTypeReference<List<ClientProfileUI>>() {
    };
    private RestOperations restOperations;
    private String employeesProfileURL;


    public ClientProfileClient(String employeesProfileURL, RestOperations restOperations) {
        this.restOperations = restOperations;
        this.employeesProfileURL = employeesProfileURL;
    }

    public void create(ClientProfileUI clientProfileUI) {
        restOperations.postForEntity(employeesProfileURL, clientProfileUI, ClientProfileUI.class);
    }

    public ClientProfileUI find(Long id) {
        String findURL = new StringBuilder(employeesProfileURL).append("/").append(id).toString();
        ClientProfileUI read = restOperations.getForEntity(findURL, ClientProfileUI.class).getBody();
        return read;
    }

    public List<ClientProfileUI> findAll() {
        return restOperations.exchange(employeesProfileURL, HttpMethod.GET, null, employeeProfileListType).getBody();
    }

}
