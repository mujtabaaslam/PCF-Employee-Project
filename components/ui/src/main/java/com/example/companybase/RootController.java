package com.example.companybase;


import com.example.companybase.clientprofileui.ClientProfileClient;
import com.example.companybase.clientprofileui.ClientProfileInitialList;
import com.example.companybase.clientprofileui.ClientProfileUI;
import com.example.companybase.clientsui.ClientUI;
import com.example.companybase.employeeprofileui.EmployeeProfileClient;
import com.example.companybase.employeeprofileui.EmployeeProfileInitialList;
import com.example.companybase.employeeprofileui.EmployeeProfileUI;
import com.example.companybase.employeesui.EmployeeUI;
import com.example.companybase.employeesui.EmployeesInitialList;
import com.example.companybase.employeesui.EmployeeClient;
import com.example.companybase.clientsui.ClientClient;
import com.example.companybase.clientsui.ClientsInitialList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class RootController {
    private EmployeesInitialList employeesInitialList;
    private EmployeeClient employeesClient;
    private ClientsInitialList clientsInitialList;
    private ClientClient clientClient;
    private EmployeeProfileClient employeeProfileClient;
    private EmployeeProfileInitialList employeeProfileInitialList;
    private ClientProfileClient clientProfileClient;
    private ClientProfileInitialList clientProfileInitialList;

    public RootController(EmployeesInitialList employeesInitialList, EmployeeClient employeesClient, ClientClient clientClient, ClientsInitialList clientsInitialList, EmployeeProfileClient employeeProfileClient, EmployeeProfileInitialList employeeProfileInitialList, ClientProfileInitialList clientProfileInitialList, ClientProfileClient clientProfileClient) {
        this.employeesInitialList = employeesInitialList;
        this.employeesClient = employeesClient;
        this.clientClient = clientClient;
        this.clientsInitialList = clientsInitialList;
        this.employeeProfileClient = employeeProfileClient;
        this.employeeProfileInitialList = employeeProfileInitialList;
        this.clientProfileInitialList = clientProfileInitialList;
        this.clientProfileClient = clientProfileClient;
    }
      
    
    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String, Object> model) {
        employeesInitialList.asList().forEach(employeesClient::create);
        model.put("employees", employeesClient.getAll());

        List employees = (List) model.get("employees");
        List<Long> ids = new ArrayList<>();
        for(int i = 0; i < employees.size(); i++){
            EmployeeUI e = (EmployeeUI) employees.get(i);
            ids.add(e.getId());
        }
        List<EmployeeProfileUI> employeeProfileList = employeeProfileInitialList.asList(ids);
        employeeProfileList.forEach(employeeProfileClient::create);
        model.put("profiles", employeeProfileClient.findAll());

        clientsInitialList.asList().forEach(clientClient::create);
        model.put("clients", clientClient.getAll());

        List clients = (List) model.get("clients");
        List<Long> cids = new ArrayList<>();
        for(int i = 0; i < clients.size(); i++){
            ClientUI c = (ClientUI) clients.get(i);
            cids.add(c.getId());
        }
        List<ClientProfileUI> clientProfileList = clientProfileInitialList.asList(cids);
        clientProfileList.forEach(clientProfileClient::create);
        model.put("clientprofiles", clientProfileClient.findAll());

        return "setup";
    }

}
