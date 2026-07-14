package com.miguegea.pokemoncompanion.character.infrastructure.adapter.in.rest.mapper;

import com.miguegea.pokemoncompanion.character.domain.model.CharacterSearchResult;
import com.miguegea.pokemoncompanion.character.infrastructure.adapter.in.rest.dto.CharacterDto;
import com.miguegea.pokemoncompanion.character.infrastructure.adapter.in.rest.dto.CharacterSearchResultDto;
import com.miguegea.pokemoncompanion.character.domain.model.Character;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterDto toDto(Character character);
    CharacterSearchResultDto toDto(CharacterSearchResult result);
}
