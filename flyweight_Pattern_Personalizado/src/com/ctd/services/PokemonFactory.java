package com.ctd.services;

import com.ctd.model.Pokemon;

import java.util.HashMap;
import java.util.Map;

public class PokemonFactory {

    private final static Map<String, Pokemon> pokemonMap = new HashMap<>();

    public static Pokemon getPokemon(String name){

        Pokemon pokemon = pokemonMap.get(name);

        if (pokemon == null){
            pokemon = new Pokemon(name);
            pokemonMap.put(name, pokemon);

            System.out.println("Pokemon has been added to pokedex!");
        }

        return pokemon;
    }
}
