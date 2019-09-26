package com.example.companybase.clientsui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ClientsInitialList {

    public List<ClientUI> asList(){

        return Arrays.asList(new ClientUI("Ford", "ford@example.com", 4, 100000),
                new ClientUI("OnePlus", "oneplus@example.com", 4, 100000000),
                new ClientUI("Amazon", "Amazon@example.com", 1, 10000000),
                new ClientUI("TD Ameritrade", "tda@example.com", 10, 7000000),
                new ClientUI("TCF Bank", "tcf@example.com", 7, 10052000),
                new ClientUI("Yahoo", "yahoo@example.com", 3, 100000000),
                new ClientUI("Apple", "apple@example.com", 4, 10000000),
                new ClientUI("Sony", "sony@example.com", 1, 1000000),
                new ClientUI("Bose", "bose@example.com", 11, 10000000),
                new ClientUI("Samsung", "samsung@example.com", 3, 10000000)
        );

    }
}
