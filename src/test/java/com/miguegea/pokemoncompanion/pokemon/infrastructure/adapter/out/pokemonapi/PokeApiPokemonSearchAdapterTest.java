package com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.out.pokemonapi;

import com.miguegea.pokemoncompanion.pokemon.domain.exception.PokemonNotFoundException;
import com.miguegea.pokemoncompanion.pokemon.domain.model.Pokemon;
import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonSearchResult;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.out.pokemonapi.dto.PokemonApiResponse;
import com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.out.pokemonapi.mapper.PokemonApiMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PokeApiPokemonSearchAdapterTest {

    private MockWebServer mockWebServer;

    private PokeApiPokemonSearchAdapter adapter;

    @Mock
    private PokemonApiMapper pokemonApiMapper;

    @BeforeEach
    void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        RestClient restClient = RestClient.builder().baseUrl(mockWebServer.url("/").toString()).build();

        adapter = new PokeApiPokemonSearchAdapter(restClient, pokemonApiMapper);
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void shouldThrowPokemonNotFoundExceptionWhenApiReturns404() {

        mockWebServer.enqueue(new MockResponse().setResponseCode(404));

        assertThrows(PokemonNotFoundException.class, () -> adapter.search("pikachua"));
    }

    @Test
    void shouldReturnPokemonSearchResultWhenApiReturns200() throws Exception {

        mockWebServer.enqueue(new MockResponse()
            .setResponseCode(200)
            .setHeader("Content-Type", "application/json")
            .setBody("""
            {
                "id": 25,
                "name": "pikachu",
                "types": []
            }
            """));

        Pokemon pokemon = new Pokemon(25, "pikachu", List.of());

        when(pokemonApiMapper.toDomain(any(PokemonApiResponse.class)))
            .thenReturn(pokemon);

        PokemonSearchResult result = adapter.search("pikachu");

        assertNotNull(result);
        assertSame(pokemon, result.pokemon());

        verify(pokemonApiMapper).toDomain(any(PokemonApiResponse.class));
    }
}

