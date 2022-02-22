package com.ctd;

import java.util.ArrayList;
import java.util.List;

public class App {

    private List<Person> people = new ArrayList<>();

    public void addPeople(Person person){

        int age = person.currentAge();
        int nameSize = person.getName().length();

        if (age > 18 &&  nameSize >= 5){
            people.add(person);
        }

    }

    public List<Person> getPeople() {
        return people;
    }
}
