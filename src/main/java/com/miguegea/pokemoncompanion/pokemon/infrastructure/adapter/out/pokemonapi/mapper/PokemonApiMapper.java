package com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.out.pokemonapi.mapper;

import com.miguegea.pokemoncompanion.pokemon.domain.model.Pokemon;
import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonType;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.out.pokemonapi.dto.PokemonApiPokemonType;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.out.pokemonapi.dto.PokemonApiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PokemonApiMapper {

    Pokemon toDomain(PokemonApiResponse response);

    @Mapping(target = "type", source = "type.name")
    PokemonType toDomain(PokemonApiPokemonType apiType);

}
