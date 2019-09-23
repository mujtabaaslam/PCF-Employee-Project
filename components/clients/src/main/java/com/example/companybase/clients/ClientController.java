package com.example.companybase.clients;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientsBean clientsBean;

    public ClientController(ClientsBean clientsBean) {
        this.clientsBean = clientsBean;
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {

        clientsBean.addClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable Long id) {
        Client doomed = clientsBean.find(id);
        if (doomed != null) clientsBean.deleteClient(doomed);
        HttpStatus status = (doomed != null) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @GetMapping("/count")
    public int count(
            @RequestParam(value = "field", required = false) String field,
            @RequestParam(value = "key", required = false) String key
    )
    {
        return (field != null && key != null) ? clientsBean.count(field, key) : clientsBean.countAll();
    }

    @GetMapping()
    public List<Client> read(
            @RequestParam(value = "field", required = false) String field,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "start", required = false) Integer start,
            @RequestParam(value = "pageSize", required = false) Integer pageSize
    ){
        if (field != null && key != null && start != null && pageSize != null)
            return clientsBean.findRange(field, key, start, pageSize);
        else if (start != null && pageSize != null)
            return clientsBean.findAll(start, pageSize);
        else
            return clientsBean.getClients();

    }

}
