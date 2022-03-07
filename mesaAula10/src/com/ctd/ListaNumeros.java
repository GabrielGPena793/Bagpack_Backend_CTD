package com.ctd;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListaNumeros {

    private static final Logger log = Logger.getLogger(ListaNumeros.class);
    List<Integer> numeros;

    public ListaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public List<Integer> getNumeros() {
        return numeros;
    }


    public void addNumero(int numero)  {
        numeros.add(numero);
    }

    public void maiorQue5(){
        if (numeros.size() > 5){
            log.info("A lista está com 5 numeros");
        }
    }

    public void maiorQue10(){

        if (numeros.size() > 10){
            log.info("A lista está com 10 numeros");
        }

    }

    public void numerosVazio() throws Exception {
        if (numeros.size() <= 0){
            throw new Exception();
        }
    }



    public double numerosMedia(){

        return (double) numeros.stream().reduce(0, Integer::sum ) / numeros.size();
    }


}
