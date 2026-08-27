package com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.controller;

import com.miguegea.pokemoncompanion.pokemon.application.usecase.port.in.PokemonUseCase;
import com.miguegea.pokemoncompanion.pokemon.domain.exception.PokemonNotFoundException;
import com.miguegea.pokemoncompanion.pokemon.domain.model.Pokemon;
import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonSearchResult;
import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonType;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.dto.PokemonDto;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.dto.PokemonSearchResultDto;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.dto.PokemonTypeDTO;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.in.rest.mapper.PokemonMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PokemonController.class)
public class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PokemonUseCase pokemonUseCase;

    @MockitoBean
    private PokemonMapper pokemonMapper;

    @Test
    void shouldReturnPokemonSearchResult() throws Exception {
        List<PokemonType> types = List.of(new PokemonType("Electric"));
        Pokemon pokemon = new Pokemon(1, "Pikachu", types);
        PokemonSearchResult searchResult = new PokemonSearchResult(pokemon, 1, 1, 1);

        List<PokemonTypeDTO> typesDTO = List.of(new PokemonTypeDTO("Electric"));
        PokemonDto pokemonDto = new PokemonDto(1, "Pikachu", typesDTO);
        PokemonSearchResultDto dto = new PokemonSearchResultDto(
            pokemonDto, 1, 1, 1
        );
        when(pokemonUseCase.search("pikachu")).thenReturn(searchResult);
        when(pokemonMapper.toDto(searchResult)).thenReturn(dto);

        mockMvc.perform(get("/api/v1/pokemon/search")
                .param("name", "pikachu"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn404WhenPokemonDoesNotExist() throws Exception {
        when(pokemonUseCase.search("nonexistentpokemon")).thenThrow(new PokemonNotFoundException("nonexistentpokemon"));

        mockMvc.perform(get("/api/v1/pokemon/search")
                .param("name", "nonexistentpokemon"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn500WhenUnexpectedExceptionOccurs() throws Exception {
        when(pokemonUseCase.search("pokemon")).thenThrow(new RuntimeException("Internal server error testing"));
        mockMvc.perform(get("/api/v1/pokemon/search")
                .param("name", "pokemon"))
            .andExpect(status().isInternalServerError());
    }

    @Test
    void shouldReturn400WhenNameIsMissing() throws Exception {
        mockMvc.perform(
                get("/api/v1/pokemon/search")
            )
            .andExpect(status().isBadRequest());
    }
}
