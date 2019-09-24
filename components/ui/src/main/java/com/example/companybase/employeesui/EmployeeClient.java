package com.example.companybase.employeesui;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {

    private static ParameterizedTypeReference<List<EmployeeUI>> employeeListType = new ParameterizedTypeReference<List<EmployeeUI>>() {
    };
    private RestOperations restOperations;
    private String employeesURL;
    private static final int CACHE_SIZE = 5;
    private final List<EmployeeUI> lastRead = new ArrayList<>(CACHE_SIZE);
    private static final Logger log = LoggerFactory.getLogger(EmployeeClient.class);


    public EmployeeClient(String employeesURL, RestOperations restOperations) {
        this.restOperations = restOperations;
        this.employeesURL = employeesURL;
    }

    public void create(EmployeeUI employee) {
        restOperations.postForEntity(employeesURL, employee, EmployeeUI.class);
    }

    @HystrixCommand(fallbackMethod="getAllFallback")
    public List<EmployeeUI> getAll() {
        List<EmployeeUI> read = restOperations.exchange(employeesURL, HttpMethod.GET, null, employeeListType).getBody();
        log.debug("Read {} employees from {}", read.size(), employeesURL);

        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++) {
            lastRead.add(read.get(i));
        }
        log.debug("Copied {} employees into the cache", copyCount);

        return read;
    }

    public List<EmployeeUI> getAllFallback() {
        log.debug("Returning {} movies from the fallback method", lastRead.size());

        return lastRead;
    }

    public void delete(Long id) {
        String deleteURL = new StringBuilder(employeesURL).append("/").append(id).toString();
        restOperations.delete(deleteURL);
    }

    @HystrixCommand(fallbackMethod="countFallback")
    public int count(String field, String key) {
        String URI = UriComponentsBuilder.fromUriString(employeesURL + "/count")
                .queryParam("field", field)
                .queryParam("key", key)
                .build().toUriString();
        return restOperations.getForEntity(URI, Integer.class).getBody();
    }

    public int countFallback(String field, String key){
        return lastRead.size();
    }

    @HystrixCommand(fallbackMethod="countAllFallback")
    public int countAll() {
        return restOperations.getForEntity(employeesURL + "/count", Integer.class).getBody();
    }

    public int countAllFallback(){
        return lastRead.size();
    }

    @HystrixCommand(fallbackMethod="findAllFallback")
    public List<EmployeeUI> findAll(int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(employeesURL)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        List<EmployeeUI> read = restOperations.exchange(URI, HttpMethod.GET, null, employeeListType).getBody();
        log.debug("Read {} employees from {}", read.size(), employeesURL);

        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++) {
            lastRead.add(read.get(i));
        }
        log.debug("Copied {} employees into the cache", copyCount);

        return read;
    }

    public List<EmployeeUI> findAllFallback(int offset, int size) {
        log.debug("Returning {} movies from the fallback method", lastRead.size());
        return lastRead;
    }

    @HystrixCommand(fallbackMethod="findRangeFallback")
    public List<EmployeeUI> findRange(String field, String key, int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(employeesURL)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        List<EmployeeUI> read = restOperations.exchange(URI, HttpMethod.GET, null, employeeListType).getBody();
        log.debug("Read {} employees from {}", read.size(), employeesURL);

        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++) {
            lastRead.add(read.get(i));
        }
        log.debug("Copied {} employees into the cache", copyCount);

        return read;

    }

    public List<EmployeeUI> findRangeFallback(String field, String key, int offset, int size) {
        log.debug("Returning {} movies from the fallback method", lastRead.size());
        return lastRead;
    }
}