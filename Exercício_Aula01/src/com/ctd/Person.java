package com.ctd;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String name;
    private LocalDate age;

    public Person() {
    }

    public Person(String name, LocalDate age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public int currentAge(){
        return Period.between(age, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        int years = currentAge();

        return "Nome: "+ name + ", " + "Idade: " + years;
    }
}
