package com.miguegea.pokemoncompanion.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pokeapi")
public record PokemonApiProperties(String baseUrl) {
}
