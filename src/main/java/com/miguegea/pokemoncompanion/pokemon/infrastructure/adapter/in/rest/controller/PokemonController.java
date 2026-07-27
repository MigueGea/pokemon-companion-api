package com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.controller;

import com.miguegea.pokemoncompanion.pokemon.application.usecase.port.in.PokemonUseCase;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.dto.PokemonSearchResultDto;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.mapper.PokemonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pokemon")
public class PokemonController {

    private final PokemonUseCase searchCharacterUseCase;
    private final PokemonMapper characterMapper;

    @GetMapping("/search")
    public PokemonSearchResultDto search(@RequestParam String name) {
        return characterMapper.toDto(
            searchCharacterUseCase.search(name)
        );
    }

}
