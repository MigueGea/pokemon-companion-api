package com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.out.pokemonapi;

import com.miguegea.pokemoncompanion.pokemon.domain.model.Pokemon;
import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonSearchResult;
import com.miguegea.pokemoncompanion.pokemon.domain.port.out.PokemonSearchPort;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.out.pokemonapi.dto.PokemonApiResponse;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.out.pokemonapi.mapper.PokemonApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * Adapter for searching pokemons using the PokeApi.
 */
@Component
@RequiredArgsConstructor
public class PokeApiPokemonSearchAdapter implements PokemonSearchPort {

    private final RestClient restClient;
    private final PokemonApiMapper pokemonApiMapper;

    @Override
    public PokemonSearchResult search(String pokemonName) {
        PokemonApiResponse  response = restClient.get().uri("/{name}",pokemonName).retrieve().body(PokemonApiResponse.class);
        Pokemon pokemon = pokemonApiMapper.toDomain(response);

        return new PokemonSearchResult(pokemon,1,1,1);
    }
}
