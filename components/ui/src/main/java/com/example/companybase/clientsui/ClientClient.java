package com.example.companybase.clientsui;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class ClientClient {

    private static ParameterizedTypeReference<List<ClientUI>> ClientListType = new ParameterizedTypeReference<List<ClientUI>>() {
    };
    private RestOperations restOperations;
    private String ClientsURL;


    public ClientClient(String ClientsURL, RestOperations restOperations) {
        this.restOperations = restOperations;
        this.ClientsURL = ClientsURL;
    }

    public void create(ClientUI Client) {
        restOperations.postForEntity(ClientsURL, Client, ClientUI.class);
    }

    public List<ClientUI> getAll() {
        return restOperations.exchange(ClientsURL, HttpMethod.GET, null, ClientListType).getBody();
    }

    public void delete(Long id) {
        String deleteURL = new StringBuilder(ClientsURL).append("/").append(id).toString();
        restOperations.delete(deleteURL);
    }

    public int count(String field, String key) {
        String URI = UriComponentsBuilder.fromUriString(ClientsURL + "/count")
                .queryParam("field", field)
                .queryParam("key", key)
                .build().toUriString();
        return restOperations.getForEntity(URI, Integer.class).getBody();
    }

    public int countAll() {
        return restOperations.getForEntity(ClientsURL + "/count", Integer.class).getBody();
    }

    public List<ClientUI> findAll(int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(ClientsURL)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, ClientListType).getBody();
    }

    public List<ClientUI> findRange(String field, String key, int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(ClientsURL)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, ClientListType).getBody();

    }

}
