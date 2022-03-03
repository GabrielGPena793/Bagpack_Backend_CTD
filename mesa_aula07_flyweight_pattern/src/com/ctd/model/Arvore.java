package com.ctd.model;

public class Arvore {

    private double altura;
    private double largura;
    private String cor;
    private static int contagem;

    public Arvore(double altura, double largura, String cor) {
        this.altura = altura;
        this.largura = largura;
        this.cor = cor;
        contagem++;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public static int getContagem() {
        return contagem;
    }

    @Override
    public String toString() {
        return "Arvore{" +
                "altura=" + altura +
                ", largura=" + largura +
                ", cor='" + cor + '\'' +
                '}';
    }
}
