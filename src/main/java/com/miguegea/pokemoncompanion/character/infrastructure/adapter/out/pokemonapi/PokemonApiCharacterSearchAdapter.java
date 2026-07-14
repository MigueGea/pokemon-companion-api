package com.miguegea.pokemoncompanion.character.infrastructure.adapter.out.pokemonapi;

import com.miguegea.pokemoncompanion.character.domain.model.CharacterSearchResult;
import com.miguegea.pokemoncompanion.character.domain.port.out.CharacterSearchPort;
import com.miguegea.pokemoncompanion.character.domain.model.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * Adapter for searching characters using the XIVAPI.
 */
@Component
@RequiredArgsConstructor
public class PokemonApiCharacterSearchAdapter implements CharacterSearchPort {

    private final RestClient restClient;

    @Override
    public CharacterSearchResult search(String characterName) {
        return new CharacterSearchResult(
            List.of(
                new Character(1L, "Test Character", "Phoenix")
            ),
            1,
            1,
            1
        );
    }
}
