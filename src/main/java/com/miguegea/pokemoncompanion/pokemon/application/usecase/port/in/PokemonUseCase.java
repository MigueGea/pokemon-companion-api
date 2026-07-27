package com.miguegea.pokemoncompanion.pokemon.application.usecase.port.in;

import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonSearchResult;

public interface PokemonUseCase {

    PokemonSearchResult search(String characterName);
}
