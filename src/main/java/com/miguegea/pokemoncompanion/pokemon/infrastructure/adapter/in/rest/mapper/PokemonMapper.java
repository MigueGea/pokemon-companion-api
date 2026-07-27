package com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.mapper;

import com.miguegea.pokemoncompanion.pokemon.domain.model.Pokemon;
import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonSearchResult;
import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonType;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.dto.PokemonDto;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.dto.PokemonSearchResultDto;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.dto.PokemonTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PokemonMapper {

    PokemonSearchResultDto toDto(PokemonSearchResult result);

    PokemonDto toDto(Pokemon pokemon);

    PokemonTypeDTO toDto(PokemonType type);
}
