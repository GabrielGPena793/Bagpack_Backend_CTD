package com.ctd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ShapeTest {



    @Test
    public void shouldReturnPositeResponseSquare(){

        Shape square = new Square(2);

        double result = square.calculatePerimeter();

        assertEquals(8 , result);
        System.out.println(result);

    }

    @Test
    public void shouldReturnPositeResponseCircle(){

        Shape circle = new Circle(1.5);

        double result = circle.calculatePerimeter();

        assertEquals(13.23746674061443 , result);

        System.out.printf("%.2f", result);

    }


}