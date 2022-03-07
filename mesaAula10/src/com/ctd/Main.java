package com.ctd;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();

        ListaNumeros listaNumeros = new ListaNumeros();
        ListaNumeros listaNumeros2 = new ListaNumeros();

        try {

            listaNumeros.addNumero(5);
            listaNumeros.addNumero(10);
            listaNumeros.addNumero(3);
            listaNumeros.addNumero(9);
            listaNumeros.addNumero(10);
            listaNumeros.addNumero(10);
            listaNumeros.maiorQue5();
            listaNumeros.maiorQue5();
            listaNumeros.addNumero(10);
            listaNumeros.addNumero(10);
            listaNumeros.addNumero(10);
            listaNumeros.addNumero(10);
            listaNumeros.addNumero(10);
            listaNumeros.maiorQue10();

            listaNumeros2.numerosVazio();


        } catch (Exception e) {
           log.error("A lista é igual a zero", e);
        }

    }
}
