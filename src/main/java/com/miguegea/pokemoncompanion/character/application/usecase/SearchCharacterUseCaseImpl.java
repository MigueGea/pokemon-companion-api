package com.miguegea.pokemoncompanion.character.application.usecase;

import com.miguegea.pokemoncompanion.character.application.usecase.port.in.SearchCharacterUseCase;
import com.miguegea.pokemoncompanion.character.domain.model.CharacterSearchResult;
import com.miguegea.pokemoncompanion.character.domain.port.out.CharacterSearchPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchCharacterUseCaseImpl implements SearchCharacterUseCase {

    private final CharacterSearchPort characterSearchPort;

    @Override
    public CharacterSearchResult search(String name) {
        return characterSearchPort.search(name);
    }
}
