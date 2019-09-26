package com.example.companybase.employeeprofileui;

public class EmployeeProfileUI {
    private long id;
    private String address;
    private String skills;
    private String certifications;

    public EmployeeProfileUI(){

    }

    public EmployeeProfileUI(long id, String address, String skills, String certifications) {
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
