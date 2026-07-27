package com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.dto;

import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonType;

import java.util.List;

public record PokemonDto(
    long id,
    String name,
    List<PokemonTypeDTO> types
) {}
