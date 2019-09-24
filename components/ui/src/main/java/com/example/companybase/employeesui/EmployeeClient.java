package com.example.companybase.employeesui;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class EmployeeClient {

    private static ParameterizedTypeReference<List<EmployeeUI>> movieListType = new ParameterizedTypeReference<List<EmployeeUI>>() {
    };
    private RestOperations restOperations;
    private String employeesURL;


    public EmployeeClient(String employeesURL, RestOperations restOperations) {
        this.restOperations = restOperations;
        this.employeesURL = employeesURL;
    }

    public void create(EmployeeUI employee) {
        restOperations.postForEntity(employeesURL, employee, EmployeeUI.class);
    }

    public List<EmployeeUI> getAll() {
        return restOperations.exchange(employeesURL, HttpMethod.GET, null, movieListType).getBody();
    }

    public void delete(Long id) {
        String deleteURL = new StringBuilder(employeesURL).append("/").append(id).toString();
        restOperations.delete(deleteURL);
    }

    public int count(String field, String key) {
        String URI = UriComponentsBuilder.fromUriString(employeesURL + "/count")
                .queryParam("field", field)
                .queryParam("key", key)
                .build().toUriString();
        return restOperations.getForEntity(URI, Integer.class).getBody();
    }

    public int countAll() {
        return restOperations.getForEntity(employeesURL + "/count", Integer.class).getBody();
    }

    public List<EmployeeUI> findAll(int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(employeesURL)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, movieListType).getBody();
    }

    public List<EmployeeUI> findRange(String field, String key, int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(employeesURL)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, movieListType).getBody();

    }
}