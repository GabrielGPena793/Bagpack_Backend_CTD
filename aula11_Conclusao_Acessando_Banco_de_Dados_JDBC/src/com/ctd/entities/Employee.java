package com.ctd.entities;

import java.util.Date;

public class Employee {

    private int id;
    private String userName;
    private int age;
    private String company;
    private Date contractDate;

    public Employee() {
    }

    public Employee(int id, String userName, int age, String company, Date contractDate) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.company = company;
        this.contractDate = contractDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                ", contractDate=" + contractDate +
                '}';
    }
}

