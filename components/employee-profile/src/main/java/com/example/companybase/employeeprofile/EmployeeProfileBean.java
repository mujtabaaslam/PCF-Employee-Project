package com.example.companybase.employeeprofile;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeProfileBean extends CrudRepository<EmployeeProfile, Long> {

    EmployeeProfile findById(Long id);
}
