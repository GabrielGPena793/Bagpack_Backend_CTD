package com.ctd;

public class Circle extends Shape {

    private double raio;

    public Circle(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double calculatePerimeter() {
        return Math.pow(2, Math.PI) * raio;
    }
}
