package com.example.companybase.clientprofile;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientprofile")
public class ClientProfileController {

    private ClientProfileBean clientProfileBean;

    public ClientProfileController(ClientProfileBean clientProfileBean) {
        this.clientProfileBean = clientProfileBean;
    }

    @PostMapping
    public ResponseEntity<ClientProfile> create(@RequestBody ClientProfile clientProfile) {

        clientProfileBean.save(clientProfile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<ClientProfile> read(){
        return clientProfileBean.findAll();
    }

    @GetMapping("/{id}")
    public ClientProfile find(@PathVariable Long id) {

        return clientProfileBean.findById(id);
    }
}
