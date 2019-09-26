package com.example.companybase.clientprofileui;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientProfileInitialList {

    public List<ClientProfileUI> asList(List<Long> ids){
        List<ClientProfileUI> list = new ArrayList<>();
        int repeat = ids.size() / 10;
        for(int i = 0; i < repeat; i++) {
            list.add(new ClientProfileUI(ids.get(0 + (10 * i)), "Jarvis Lin", "Automobile", "Detroit, MI", 20));
            list.add(new ClientProfileUI(ids.get(1 + (10 * i)), "Jarvis Lin", "Mobile", "San Francisco, CA", 2));
            list.add(new ClientProfileUI(ids.get(2 + (10 * i)), "Chanelle Laing", "Technology", "Boston, MA", 11));
            list.add(new ClientProfileUI(ids.get(3 + (10 * i)), "Elle Garner", "Finance", "New York City, NY", 15));
            list.add(new ClientProfileUI(ids.get(4 + (10 * i)), "Harri Cruz", "Finance", "Chicago, IL", 6));
            list.add(new ClientProfileUI(ids.get(5 + (10 * i)), "Shannon Oakley", "Technology", "Livonia, MI", 9));
            list.add(new ClientProfileUI(ids.get(6 + (10 * i)), "Thomas Mora", "Technology", "Ann Arbor, MI", 5));
            list.add(new ClientProfileUI(ids.get(7 + (10 * i)), "Alberto Foster", "Technology", "Houston, TX", 14));
            list.add(new ClientProfileUI(ids.get(8 + (10 * i)), "Faheem Friedman", "Technology", "Dallas, TX", 12));
            list.add(new ClientProfileUI(ids.get(9 + (10 * i)), "Rumaisa Cunningham", "Technology", "Jersey City, NJ", 17));



        }
        return list;
    }
}
