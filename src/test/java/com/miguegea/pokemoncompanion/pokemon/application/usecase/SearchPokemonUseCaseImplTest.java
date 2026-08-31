package com.miguegea.pokemoncompanion.pokemon.application.usecase;

import com.miguegea.pokemoncompanion.pokemon.domain.model.Pokemon;
import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonSearchResult;
import com.miguegea.pokemoncompanion.pokemon.domain.model.PokemonType;
import com.miguegea.pokemoncompanion.pokemon.domain.port.out.PokemonSearchPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchPokemonUseCaseImplTest {
    @Mock
    private PokemonSearchPort pokemonSearchPort;

    @InjectMocks
    private SearchPokemonUseCaseImpl searchPokemonUseCase;

    @Test
    void shouldReturnPokemonSearchResult() {
        List<PokemonType> types = List.of(new PokemonType("electric"));
        Pokemon pokemon = new Pokemon(1, "Pikachu", types);
        int totalResults = 1;
        int page = 1;
        int pageSize = 1;
        PokemonSearchResult expected = new PokemonSearchResult(pokemon, totalResults, page, pageSize);

        when(pokemonSearchPort.search("pikachu"))
            .thenReturn(expected);

        PokemonSearchResult result =
            searchPokemonUseCase.search("pikachu");

        assertSame(expected, result);
        verify(pokemonSearchPort).search("pikachu");
    }
}
