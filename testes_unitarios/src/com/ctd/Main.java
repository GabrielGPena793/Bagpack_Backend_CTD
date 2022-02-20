package com.ctd;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Person person = new Person("Gabriel", "Gomes", "gabriel@hotmail.com", sdf.parse("28/03/2003") );

        System.out.println(person.overEighteen());
        System.out.println(person.fullName());

    }
}
