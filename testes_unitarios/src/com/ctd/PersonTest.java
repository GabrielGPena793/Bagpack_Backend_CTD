package com.ctd;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
class PersonTest {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    @Test
    public void shouldRetornFullNameSeparatedWithSpaces() throws ParseException {

        Person person = new Person("Gabriel", "Gomes", "gabriel@hotmail.com", sdf.parse("28/03/2003"));

        String fullName = person.fullName();

        assertEquals(person.getName() + " " + person.getLastName(), fullName);

    }

    @Test
    public void shouldRetornTrueWhenAgeOverEighteen() throws ParseException {
        Person person = new Person("Gabriel", "Gomes", "gabriel@hotmail.com", sdf.parse("28/03/2003"));

        boolean overEighteen = person.overEighteen();

        assertTrue(overEighteen);

    }

    @Test
    public void shouldRetornFalseWhenAgeLessThanEighteen() throws ParseException {
        Person person = new Person("Gabriel", "Gomes", "gabriel@hotmail.com", sdf.parse("28/03/2004"));

        boolean overEighteen = person.overEighteen();

        assertFalse(overEighteen);

    }

}