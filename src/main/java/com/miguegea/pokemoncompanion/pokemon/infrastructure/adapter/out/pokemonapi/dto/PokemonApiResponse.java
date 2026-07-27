package com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.out.pokemonapi.dto;


import java.util.List;

public record PokemonApiResponse(int id, String name, List<PokemonApiPokemonType> types) {
}
