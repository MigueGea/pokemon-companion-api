package com.miguegea.pokemoncompanion.pokemon.application.usecase;

import com.miguegea.pokemoncompanion.pokemon.application.usecase.port.in.PokemonUseCase;
import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonSearchResult;
import com.miguegea.pokemoncompanion.pokemon.domain.port.out.PokemonSearchPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchPokemonUseCaseImpl implements PokemonUseCase {

    private final PokemonSearchPort pokemonSearchPort;

    @Override
    public PokemonSearchResult search(String name) {
        return pokemonSearchPort.search(name);
    }
}
