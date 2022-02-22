package com.ctd.entities;

public abstract class Cardapio {

    private double precoBase;

    public Cardapio(double precoBase) {
        this.precoBase = precoBase;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public void preparo(){
        double valor;
        valor = calcularPrecoVenda();
        mensagemFuncionario(valor);
    };

    public abstract void mensagemFuncionario(double valor);

    public abstract double calcularPrecoVenda();
}
