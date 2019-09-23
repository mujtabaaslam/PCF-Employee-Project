package com.example.companybase.clientsui;

public class ClientUI {

    private long id;
    private String name;
    private String email;
    private int years;
    private long projectValue;

    public ClientUI(){
    }

    public ClientUI(String name, String email, int years, long projectValue) {
        this.name = name;
        this.email = email;
        this.years = years;
        this.projectValue = projectValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public long getProjectValue() {
        return projectValue;
    }

    public void setProjectValue(long projectValue) {
        this.projectValue = projectValue;
    }
}
