package com.example.companybase.employeeprofile;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeProfile {

    @Id
    private long id;
    private String address;
    private String skills;
    private String certifications;

    public EmployeeProfile(){

    }

    public EmployeeProfile(long id, String address, String skills, String certifications) {
        this.id = id;
        this.address = address;
        this.skills = skills;
        this.certifications = certifications;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }
}
