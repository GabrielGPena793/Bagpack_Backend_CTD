package com.ctd.entities;

public class CardapioVegetariano extends Cardapio{

    private boolean condimentos;


    public CardapioVegetariano(double precoBase, boolean condimentos) {
        super(precoBase);
        this.condimentos = condimentos;
    }


    @Override
    public void mensagemFuncionario(double valor) {

        if (condimentos) System.out.printf("Cadio Vegetariano + condimentos - Valor: %.2f", valor);
        else System.out.printf("Cadio Vegetariano - Valor: %.2f %n", valor);

    }

    @Override
    public double calcularPrecoVenda() {

        if (condimentos) return getPrecoBase() * 1.01;
        return getPrecoBase();

    }
}
