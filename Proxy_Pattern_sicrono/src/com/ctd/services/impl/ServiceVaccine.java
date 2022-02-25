package com.ctd.services.impl;

import com.ctd.services.Vaccine;

import java.util.Date;

public class ServiceVaccine  implements Vaccine {

    @Override
    public void vaccinePerson(String rg, Date dataVacine, String typeVaccine) {
        System.out.println("User: " + rg + " vaccinated in " + dataVacine + " successfully!");
    }

}
