package com.miguegea.pokemoncompanion.character.infrastructure.adapter.in.rest.controller;

import com.miguegea.pokemoncompanion.character.application.usecase.port.in.SearchCharacterUseCase;
import com.miguegea.pokemoncompanion.character.infrastructure.adapter.in.rest.dto.CharacterSearchResultDto;
import com.miguegea.pokemoncompanion.character.infrastructure.adapter.in.rest.mapper.CharacterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/characters")
public class CharacterController {

    private final SearchCharacterUseCase searchCharacterUseCase;
    private final CharacterMapper characterMapper;

    @GetMapping("/search")
    public CharacterSearchResultDto search(@RequestParam String name) {
        return characterMapper.toDto(
            searchCharacterUseCase.search(name)
        );
    }

}
