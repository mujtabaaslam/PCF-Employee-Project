package com.example.companybase;


import com.example.companybase.employeesui.EmployeesInitialList;
import com.example.companybase.employeesui.EmployeeClient;
import com.example.companybase.clientsui.ClientClient;
import com.example.companybase.clientsui.ClientsInitialList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RootController {
    private EmployeesInitialList employeesInitialList;
    private EmployeeClient employeesClient;
    private ClientsInitialList clientsInitialList;
  private ClientClient clientClient;

    public RootController(EmployeesInitialList employeesInitialList, EmployeeClient employeesClient, ClientClient clientClient, ClientsInitialList clientsInitialList) {
        this.employeesInitialList = employeesInitialList;
        this.employeesClient = employeesClient;
        this.clientClient = clientClient;
        this.clientsInitialList = clientsInitialList;
      
    }
      
    
    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String, Object> model) {
        employeesInitialList.asList().forEach(employeesClient::create);

        model.put("employees", employeesClient.getAll());

        clientsInitialList.asList().forEach(clientClient::create);

        model.put("clients", clientClient.getAll());

        return "setup";
    }

}
