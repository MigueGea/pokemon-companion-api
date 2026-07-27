package com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.dto;

import com.miguegea.pokemoncompanion.pokemon.domain.model.Pokemon;


public record PokemonSearchResultDto(
    PokemonDto pokemon,
    int page,
    int pageSize,
    int totalResults
) {}
