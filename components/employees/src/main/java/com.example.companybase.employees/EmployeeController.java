package com.example.companybase.employees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeesBean employeeBean;

    public EmployeeController(EmployeesBean employeesBean) {
        this.employeeBean = employeesBean;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {

        employeeBean.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        Employee doomed = employeeBean.find(id);
        if (doomed != null) employeeBean.deleteEmployee(doomed);
        HttpStatus status = (doomed != null) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @GetMapping("/count")
    public int count(
            @RequestParam(value = "field", required = false) String field,
            @RequestParam(value = "key", required = false) String key
    )
    {
        return (field != null && key != null) ? employeeBean.count(field, key) : employeeBean.countAll();
    }

    @GetMapping()
    public List<Employee> read(
            @RequestParam(value = "field", required = false) String field,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "start", required = false) Integer start,
            @RequestParam(value = "pageSize", required = false) Integer pageSize
    ){
        if (field != null && key != null && start != null && pageSize != null)
            return employeeBean.findRange(field, key, start, pageSize);
        else if (start != null && pageSize != null)
            return employeeBean.findAll(start, pageSize);
        else
            return employeeBean.getEmployees();

    }

}
