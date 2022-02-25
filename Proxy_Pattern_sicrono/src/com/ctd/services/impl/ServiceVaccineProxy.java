package com.ctd.services.impl;

import com.ctd.services.Vaccine;

import java.util.Date;

public class ServiceVaccineProxy  implements Vaccine {

    private ServiceVaccine serviceVaccine;

    @Override
    public void vaccinePerson(String rg, Date dataVacine, String typeVaccine) {
        if (dataVacine.after(new Date())){
            serviceVaccine = new ServiceVaccine();
            serviceVaccine.vaccinePerson(rg, dataVacine, typeVaccine);
            System.out.println("Person vaccinated");
        }
        else {
            System.out.println("Today's date is before the scheduled date");
        }
    }
}
