package com.example.companybase.clientprofile;

import org.springframework.data.repository.CrudRepository;

public interface ClientProfileBean extends CrudRepository<ClientProfile, Long> {

    ClientProfile findById(Long id);
}
