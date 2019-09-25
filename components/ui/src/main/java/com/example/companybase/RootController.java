package com.example.companybase;


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

    public RootController(EmployeesInitialList employeesInitialList, EmployeeClient employeesClient, ClientClient clientClient, ClientsInitialList clientsInitialList, EmployeeProfileClient employeeProfileClient, EmployeeProfileInitialList employeeProfileInitialList) {
        this.employeesInitialList = employeesInitialList;
        this.employeesClient = employeesClient;
        this.clientClient = clientClient;
        this.clientsInitialList = clientsInitialList;
        this.employeeProfileClient = employeeProfileClient;
        this.employeeProfileInitialList = employeeProfileInitialList;
    }
      
    
    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String, Object> model) {
        List<EmployeeUI> employeeList = employeesInitialList.asList();
        employeeList.forEach(employeesClient::create);

        List<Long> ids = new ArrayList<>();
        for(int i = 0; i < employeeList.size(); i++){
            ids.add(employeeList.get(i).getId());
        }

        List<EmployeeProfileUI> employeeProfileList = employeeProfileInitialList.asList(ids);
        employeeProfileList.forEach(employeeProfileClient::create);

        model.put("profiles", employeeProfileClient.findAll());

        model.put("employees", employeesClient.getAll());

        clientsInitialList.asList().forEach(clientClient::create);

        model.put("clients", clientClient.getAll());

        return "setup";
    }

}
