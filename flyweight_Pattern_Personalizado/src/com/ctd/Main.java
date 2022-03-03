package com.ctd;

import com.ctd.model.Pokemon;
import com.ctd.services.PokemonFactory;

public class Main {

    public static void main(String[] args) {

        Pokemon pokemon = PokemonFactory.getPokemon("Pikachu");
        pokemon.setEnvolved(false);

        System.out.println(pokemon);

        System.out.println("=====================================");
        pokemon = PokemonFactory.getPokemon("Pikachu");
        pokemon.setEnvolved(false);
        System.out.println(pokemon);
    }
}
