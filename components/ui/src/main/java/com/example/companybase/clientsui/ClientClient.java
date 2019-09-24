package com.example.companybase.clientsui;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ClientClient {

    private static ParameterizedTypeReference<List<ClientUI>> ClientListType = new ParameterizedTypeReference<List<ClientUI>>() {
    };
    private RestOperations restOperations;
    private String ClientsURL;
    private static final int CACHE_SIZE = 5;
    private final List<ClientUI> lastRead = new ArrayList<>(CACHE_SIZE);
    private static final Logger log = LoggerFactory.getLogger(ClientClient.class);


    public ClientClient(String ClientsURL, RestOperations restOperations) {
        this.restOperations = restOperations;
        this.ClientsURL = ClientsURL;
    }

    public void create(ClientUI Client) {
        restOperations.postForEntity(ClientsURL, Client, ClientUI.class);
    }

    @HystrixCommand(fallbackMethod="getAllFallback")
    public List<ClientUI> getAll() {
        List<ClientUI> read =  restOperations.exchange(ClientsURL, HttpMethod.GET, null, ClientListType).getBody();
        log.debug("Read {} clients from {}", read.size(), ClientsURL);

        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++)
            lastRead.add(read.get(i));
        log.debug("Copied {} clients into the cache", copyCount);

        return read;
    }

    public List<ClientUI> getAllFallback() {
        log.debug("Returning {} clients from the fallback method", lastRead.size());

        return lastRead;
    }

    public void delete(Long id) {
        String deleteURL = new StringBuilder(ClientsURL).append("/").append(id).toString();
        restOperations.delete(deleteURL);
    }

    @HystrixCommand(fallbackMethod="countFallback")
    public int count(String field, String key) {
        String URI = UriComponentsBuilder.fromUriString(ClientsURL + "/count")
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
        return restOperations.getForEntity(ClientsURL + "/count", Integer.class).getBody();
    }

    public int countAllFallback(){
        return lastRead.size();
    }

    @HystrixCommand(fallbackMethod="findAllFallback")
    public List<ClientUI> findAll(int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(ClientsURL)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        List<ClientUI> read = restOperations.exchange(URI, HttpMethod.GET, null, ClientListType).getBody();
        log.debug("Read {} clients from {}", read.size(), ClientsURL);

        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++)
            lastRead.add(read.get(i));
        log.debug("Copied {} clients into the cache", copyCount);

        return read;
    }

    public List<ClientUI> findAllFallback(int offset, int size) {
        log.debug("Returning {} clients from the fallback method", lastRead.size());
        return lastRead;
    }

    @HystrixCommand(fallbackMethod="findRangeFallback")
    public List<ClientUI> findRange(String field, String key, int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(ClientsURL)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        List<ClientUI> read = restOperations.exchange(URI, HttpMethod.GET, null, ClientListType).getBody();
        log.debug("Read {} clients from {}", read.size(), ClientsURL);

        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++)
            lastRead.add(read.get(i));
        log.debug("Copied {} clients into the cache", copyCount);

        return read;

    }

    public List<ClientUI> findRangeFallback(String field, String key, int offset, int size) {
        log.debug("Returning {} clients from the fallback method", lastRead.size());
        return lastRead;
    }

}
