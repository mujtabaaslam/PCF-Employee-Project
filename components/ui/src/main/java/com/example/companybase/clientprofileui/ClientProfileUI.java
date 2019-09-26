package com.example.companybase.clientprofileui;

public class ClientProfileUI {
    private long id;
    private String contact;
    private String industry;
    private String location;
    private int employees;

    public ClientProfileUI(){

    }

    public ClientProfileUI(long id, String contact, String industry, String location, int employees) {
        this.id = id;
        this.contact = contact;
        this.industry = industry;
        this.location = location;
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }
}
