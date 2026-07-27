package com.miguegea.pokemoncompanion.pokemon.domain.model;

import java.util.List;
import java.util.Objects;

public record Pokemon(
    long id,
    String name,
    List<PokemonType> types
) {

    public Pokemon {
        Objects.requireNonNull(name, "name must not be null");
    }

}
