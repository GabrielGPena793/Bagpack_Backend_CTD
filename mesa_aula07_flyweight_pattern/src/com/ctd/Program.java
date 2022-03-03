package com.ctd;

import com.ctd.factory.ArvoreFactory;
import com.ctd.model.Arvore;

public class Program {

    public static void main(String[] args) {

        ArvoreFactory arvoreFactory = new ArvoreFactory();

        //arvores vermelhas.
        for (int i = 1; i <= 500000; i++){
            Arvore arvoreFrutifera = arvoreFactory.getArvore(500, 300, "vermelho");
        }

        //arvores verdes.
        for (int i = 1; i <= 500000; i++){
            Arvore arvoreOrnamental = arvoreFactory.getArvore(200, 400, "verde");
        }

        //print da memória usada.
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

        //print da quantidade de instâncias.
        System.out.println(Arvore.getContagem());
    }
}
