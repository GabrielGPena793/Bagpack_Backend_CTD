package com.ctd.model;

import com.ctd.services.Vaccine;
import com.ctd.services.impl.ServiceVaccine;
import org.junit.jupiter.api.Test;

import java.util.Date;

class PersonTest {

    Date dataVac = new Date();

    @Test
    public void vacTest(){
        Person p1 = new Person("Gabriel", "Gomes", "215131313", dataVac, "jstsky");
        Vaccine vaccine = new ServiceVaccine();
        vaccine.vaccinePerson(p1.getRg(), p1.getDateVacine(), p1.getNameVacine());
        System.out.println(p1);
    }
}