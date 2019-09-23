package com.example.companybase.clientsui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ClientsInitialList {

    public List<ClientUI> asList(){

        return Arrays.asList(new ClientUI("ABC", "abc@example.com", 4, 100000));

    }
}
