package com.ctd;

import java.util.Calendar;
import java.util.Date;

public class Person {

    private String name;
    private String lastName;
    private String email;
    private Date age;

    public Person() {
    }

    public Person(String name, String lastName, String email, Date age) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String fullName(){
        return lastName + " " + name;
    }

    public boolean overEighteen(){
        Date currentDate = new Date();
        Calendar current = Calendar.getInstance();
        Calendar agePerson = Calendar.getInstance();

        agePerson.setTime(age);
        current.setTime(currentDate);

        int age = current.get(Calendar.YEAR) - agePerson.get(Calendar.YEAR);

        return age > 18;
    }
}
