package com.ctd.service;

import com.ctd.model.Quadrado;
import com.ctd.model.Triangulo;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    public static final Map<String, Triangulo> trianguloMap = new HashMap<>();
    public static final Map<Integer, Quadrado> quadradoMap = new HashMap<>();

    public static Triangulo obterTriangulo(String cor){

        Triangulo triangulo = trianguloMap.get(cor);

        if (triangulo == null){

            triangulo = new Triangulo(cor);
            trianguloMap.put(cor, triangulo);

        }

        return  triangulo;
    }

    public static Quadrado obterQuadrado(Integer tamanho){

        Quadrado quadrado = quadradoMap.get(tamanho);

        if (quadrado == null){
            quadrado = new Quadrado(tamanho);
            quadradoMap.put(tamanho, quadrado);
        }

        return quadrado;
    }


}
