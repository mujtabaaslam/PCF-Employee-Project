package com.example.companybase.clientprofileui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ClientProfileActionServlet {

    private ClientProfileClient clientProfileClient;

    public ClientProfileActionServlet(ClientProfileClient clientProfileClient) {
        this.clientProfileClient = clientProfileClient;
    }

    @GetMapping("/clientprofile")
    public String findProfile(Map<String, Object> model,
                              @RequestParam("id") long id,
                              @RequestParam("n") String name,
                              @RequestParam("e") String email,
                              @RequestParam("y") String years,
                              @RequestParam("p") String projectValue) {
        model.put("clientprofile", clientProfileClient.find(id));
        model.put("name", name);
        model.put("email", email);
        model.put("years", years);
        model.put("projectValue", projectValue);
        return "clientprofile";
    }

}
