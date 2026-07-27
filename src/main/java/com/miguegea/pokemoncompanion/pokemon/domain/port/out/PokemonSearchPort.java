package com.miguegea.pokemoncompanion.pokemon.domain.port.out;

import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonSearchResult;

public interface PokemonSearchPort {

    PokemonSearchResult search(String characterName);
}
