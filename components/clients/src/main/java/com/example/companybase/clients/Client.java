package com.example.companybase.clients;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private int years;
    private long projectValue;

    public Client(){
    }

    public Client(String name, String email, int years, long projectValue) {
        this.name = name;
        this.email = email;
        this.years = years;
        this.projectValue = projectValue;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
