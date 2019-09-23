/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.companybase.employees;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String FirstName;
    private String LastName;
    private String email;
    private int Salary;
    private String Title;
    private String Department;

    public Employee() {
    }

    public Employee(String FirstName, String LastName, String email, int Salary, String Title, String Department) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.email = email;
        this.Salary = Salary;
        this.Title = Title;
        this.Department = Department;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String FirstName) {this.FirstName = FirstName;}

    public String getLastName(){return this.LastName;}

    public void setLastName(String LastName) {this.LastName = LastName;}

    public String getEmail() {return this.email;}

    public void setEmail() {this.email = email;}

    public int getSalary() {return this.Salary;}

    public void setSalary(int salary) {this.Salary = salary;}

    public String getTitle() {return this.Title;}

    public void setTitle(String title) {this.Title = title;}

    public String getDepartment(){return this.Department;}

    public void setDepartment(String department) {
        this.Department = department;
    }
}