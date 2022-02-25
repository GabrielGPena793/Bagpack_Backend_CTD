package com.ctd.services.impl;

import com.ctd.model.exceptions.SeriesNotEnableExecption;
import com.ctd.services.ISerie;

import java.util.ArrayList;
import java.util.List;

public class SerieServiceProxy implements ISerie {

    private SerieService serieService = new SerieService();
    private List<String> numberSeries = new ArrayList<>();

    // ira armazenar no array toda vez que uma série for vista e retona a mesma, caso passe de 5 series no array
    // irá ocorrer uma exceção
    @Override
    public String getSerie(String name) {

        if (numberSeries.size()<= 4){
            numberSeries.add(name);
            return serieService.getSerie(name);
        }

        throw new SeriesNotEnableExecption("Exceeds the number of allowed plays");
    }
}
