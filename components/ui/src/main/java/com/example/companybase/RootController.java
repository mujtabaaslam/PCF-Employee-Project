package com.example.companybase;

import com.example.companybase.clients.ClientsBean;
import com.example.companybase.clients.ClientsInitialList;
import com.example.companybase.employeesui.EmployeesInitialList;
import com.example.companybase.employeesui.EmployeeClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RootController {
    private EmployeesInitialList employeesInitialList;
    private EmployeeClient employeesBean;
    private ClientsInitialList clientsInitialList;
    private ClientsBean clientsBean;

    public RootController(EmployeesInitialList employeesInitialList, EmployeeClient employeesBean, ClientsBean clientsBean, ClientsInitialList clientsInitialList) {
        this.employeesInitialList = employeesInitialList;
        this.employeesBean = employeesBean;
        this.clientsBean = clientsBean;
        this.clientsInitialList = clientsInitialList;
    }

    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String, Object> model) {
        employeesInitialList.asList().forEach(employeesBean::create);

        model.put("employees", employeesBean.getAll());

        clientsInitialList.asList().forEach(clientsBean::addClient);

        model.put("clients", clientsBean.getClients());

        return "setup";
    }

}
