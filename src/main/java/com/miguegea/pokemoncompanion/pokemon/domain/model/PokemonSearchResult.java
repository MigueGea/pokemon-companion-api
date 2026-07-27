package com.miguegea.pokemoncompanion.pokemon.domain.model;

import java.util.List;

public record PokemonSearchResult(Pokemon pokemon, int totalResults, int page, int pageSize) {
}
