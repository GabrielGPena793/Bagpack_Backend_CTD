package com.ctd.factory;

import com.ctd.model.Arvore;

import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    private static Map<String , Arvore> arvoreMap = new HashMap<>();

    public Arvore getArvore(double altura, double largura, String cor){

        String dadosArvore = "Dados: " + ", Altura: "+ altura + ", Lagura: " + largura +  ", Cor: " + cor;

        if (!arvoreMap.containsKey(dadosArvore)){
            arvoreMap.put(dadosArvore, new Arvore(altura, largura, cor));
            System.out.println("Arvore criada");
            return arvoreMap.get(dadosArvore);
        }

        System.out.println("Arvore existente");
        return arvoreMap.get(dadosArvore);
    }

    public static Map<String, Arvore> getArvoreMap() {
        return arvoreMap;
    }
}
