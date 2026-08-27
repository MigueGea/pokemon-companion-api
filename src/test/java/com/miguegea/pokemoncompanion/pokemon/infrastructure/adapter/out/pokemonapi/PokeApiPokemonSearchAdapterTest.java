package com.miguegea.pokemoncompanion.pokemon.infrastructure.adapter.out.pokemonapi;

import com.miguegea.pokemoncompanion.pokemon.domain.exception.PokemonNotFoundException;
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

import static org.junit.jupiter.api.Assertions.assertThrows;

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
}

