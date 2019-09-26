package com.example.companybase.employeeprofile;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class EmployeeProfileController {

    private EmployeeProfileBean employeeProfileBean;

    public EmployeeProfileController(EmployeeProfileBean employeeProfileBean) {
        this.employeeProfileBean = employeeProfileBean;
    }

    @PostMapping
    public ResponseEntity<EmployeeProfile> create(@RequestBody EmployeeProfile employeeProfile) {

        employeeProfileBean.save(employeeProfile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<EmployeeProfile> read(){
        return employeeProfileBean.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeProfile find(@PathVariable Long id) {

        return employeeProfileBean.findById(id);
    }
}
