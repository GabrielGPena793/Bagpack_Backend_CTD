package com.ctd.tests;

import com.ctd.model.exceptions.SeriesNotEnableExecption;
import com.ctd.services.ISerie;
import com.ctd.services.impl.SerieServiceProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ISerieTest {

    //teste que verifica se tem retorno enquanto ainda tem limites de visualizações
    @Test
    public void shouldReturnSerieWhenLimitAvaliable(){

        ISerie serie = new SerieServiceProxy();

        String link = serie.getSerie("Game of Thrones");

        assertEquals("www.GameofThrones.com", link);
        System.out.println(link);

    }


    //teste que verifica se vai ocorrer uma exceção caso passe de 5 series;
    @Test
    public void shouldReturnExcptionWhenLimitExceededLimit() {

        ISerie serie = new SerieServiceProxy();

        serie.getSerie("Breaking Bad");
        serie.getSerie("La casa de papel");
        serie.getSerie("Vikings");
        serie.getSerie("Euphoria");
        serie.getSerie("SEE");

        // Nesta parte faz mais outra chamada da função. Somando 6 chamadas no total;
        SeriesNotEnableExecption execption = assertThrows(SeriesNotEnableExecption.class, () -> serie.getSerie("Invasion"));

        assertEquals("Exceeds the number of allowed plays", execption.getMessage());
        System.out.println(execption.getMessage());

    }

}