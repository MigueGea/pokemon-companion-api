package com.miguegea.pokemoncompanion.pokemon.domain.exception;

public class PokemonNotFoundException extends RuntimeException {

    public PokemonNotFoundException(String name) {
        super("Pokemon not found: " + name);
    }
}
