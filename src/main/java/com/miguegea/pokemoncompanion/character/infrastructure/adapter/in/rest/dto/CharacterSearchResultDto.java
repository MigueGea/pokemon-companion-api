package com.miguegea.pokemoncompanion.character.infrastructure.adapter.in.rest.dto;

import java.util.List;

public record CharacterSearchResultDto(
    List<CharacterDto> characters,
    int page,
    int pageSize,
    int totalResults
) {}
