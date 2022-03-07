package com.ctd.test;

import com.ctd.model.Quadrado;
import com.ctd.model.Triangulo;
import com.ctd.service.FlyweightFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlyweightFactoryTest {

    @Test
    public void getTriangulo(){

        Triangulo triangulo = FlyweightFactory.obterTriangulo("Vermelho");
        triangulo.setTamanho(2);

        Triangulo triangulo1 = FlyweightFactory.obterTriangulo("Vermelho");
        triangulo1.setTamanho(4);

        Triangulo triangulo2 = FlyweightFactory.obterTriangulo("Azul");
        triangulo2.setTamanho(6);

        assertEquals("Vermelho", triangulo.getCor());
        assertEquals(4, triangulo1.getTamanho());
        assertEquals(2, FlyweightFactory.trianguloMap.size());

    }


    @Test
    public void getQuadrado(){

        Quadrado quadrado = FlyweightFactory.obterQuadrado(4);
        quadrado.setCor("blue");

        Quadrado quadrado1 = FlyweightFactory.obterQuadrado(6);
        quadrado1.setCor("Red");

        Quadrado quadrado2 = FlyweightFactory.obterQuadrado(4);
        quadrado.setCor("Yellow");


        assertEquals(4, quadrado.getTamanho());
        assertEquals(6, quadrado1.getTamanho());
        assertEquals(2, FlyweightFactory.quadradoMap.size());

        FlyweightFactory.quadradoMap.values().forEach(System.out::println);
    }


}
