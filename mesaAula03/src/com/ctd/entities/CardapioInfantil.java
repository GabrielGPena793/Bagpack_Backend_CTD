package com.ctd.entities;

public class CardapioInfantil  extends Cardapio{

    private double custoAdicional;

    public CardapioInfantil(double precoBase, double custoAdicional) {
        super(precoBase);
        this.custoAdicional = custoAdicional;
    }

    @Override
    public void mensagemFuncionario(double valor) {

        System.out.printf("Cadio Infatil - Valor: %.2f %n", valor);

    }

    @Override
    public double calcularPrecoVenda() {
        return getPrecoBase() + custoAdicional;
    }
}
