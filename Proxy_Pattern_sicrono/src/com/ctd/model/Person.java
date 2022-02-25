package com.ctd.model;

import java.util.Date;

public class Person {

    private String name;
    private String sobrenome;
    private String rg;
    private Date dateVacine;
    private String nameVacine;

    public Person() {
    }

    public Person(String name, String sobrenome, String rg, Date dateVacine, String nameVacine) {
        this.name = name;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dateVacine = dateVacine;
        this.nameVacine = nameVacine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDateVacine() {
        return dateVacine;
    }

    public void setDateVacine(Date dateVacine) {
        this.dateVacine = dateVacine;
    }

    public String getNameVacine() {
        return nameVacine;
    }

    public void setNameVacine(String nameVacine) {
        this.nameVacine = nameVacine;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", rg='" + rg + '\'' +
                ", dateVacine=" + dateVacine +
                ", nameVacine='" + nameVacine + '\'' +
                '}';
    }
}
