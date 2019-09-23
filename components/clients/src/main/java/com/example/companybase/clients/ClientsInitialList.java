package com.example.companybase.clients;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

public class ClientsInitialList {

    @Component
    public List<Client> asList(){

        return Arrays.asList(new Client("ABC", "abc@example.com", 4, 100000));

    }
}