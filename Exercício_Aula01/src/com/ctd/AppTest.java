package com.ctd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    Person p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
    App app = new App();

    @BeforeEach
    public void instantPeaple(){
        p1 = new Person("Jorge", LocalDate.of(2018,5,25));
        p2 = new Person("Maria", LocalDate.of(2017,5,25));
        p3 = new Person("Lucas", LocalDate.of(2005,5,25));
        p4 = new Person("Laura", LocalDate.of(2010,5,25));
        p5 = new Person("Cleyton", LocalDate.of(1990,5,25));
        p6 = new Person("Lis", LocalDate.of(2015,5,25));
        p7 = new Person("Katia", LocalDate.of(2020,5,25));
        p8 = new Person("Lurdes", LocalDate.of(1988,5,25));
        p9 = new Person("Kaio", LocalDate.of(1995,5,25));
        p10 = new Person("Pedro", LocalDate.of(2009,5,25));

        app.addPeople(p1);
        app.addPeople(p2);
        app.addPeople(p3);
        app.addPeople(p4);
        app.addPeople(p5);
        app.addPeople(p6);
        app.addPeople(p7);
        app.addPeople(p8);
        app.addPeople(p9);
        app.addPeople(p10);
    }

    @Test
    public void SholdReturnPeopleWhenAgeOverEighteenAndNameSizeEqualsOrOverFive(){

        for (Person person: app.getPeople()) {
            assertTrue(person.currentAge() > 18);
            assertTrue(person.getName().length() >= 5);
            System.out.println(person);
        }

    }

    @Test
    public void shouldReturnTwoPeapleInArray(){

        assertEquals(2, app.getPeople().size());

        System.out.println(app.getPeople().size());
    }
}