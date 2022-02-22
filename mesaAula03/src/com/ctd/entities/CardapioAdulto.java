package com.ctd.entities;

public class CardapioAdulto extends Cardapio {


    public CardapioAdulto(double precoBase) {
        super(precoBase);
    }

    @Override
    public void mensagemFuncionario(double valor) {

        System.out.printf("Cadio Adulto - Valor: %.2f %n", valor);

    }

    @Override
    public double calcularPrecoVenda() {
        return getPrecoBase();
    }
}
