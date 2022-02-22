package com.ctd.entities;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    public void preparoInfantil(){
        Cardapio cardapioInfantil = new CardapioInfantil(33.50, 5);

        double valorAtual = cardapioInfantil.calcularPrecoVenda();

        assertEquals(38.50, valorAtual );

        cardapioInfantil.preparo();
    }

    @Test
    public void preparoAdulto(){
        Cardapio cardapioAdulto = new CardapioAdulto(41.30);

        double valorAtual = cardapioAdulto.calcularPrecoVenda();

        assertEquals(41.30, valorAtual );

        cardapioAdulto.preparo();
    }

    @Test
    public void preparoVegetarianoComCondimentos(){
        Cardapio cardapioVegetariano = new CardapioVegetariano(50, true);

        double valorAtual = cardapioVegetariano.calcularPrecoVenda();

        assertEquals(50 * 1.01, valorAtual );

        cardapioVegetariano.preparo();
    }

    @Test
    public void preparoVegetarianoSemCondimentos(){
        Cardapio cardapioVegetariano = new CardapioVegetariano(50, false);

        double valorAtual = cardapioVegetariano.calcularPrecoVenda();

        assertEquals(50, valorAtual );

        cardapioVegetariano.preparo();
    }
}