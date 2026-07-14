package com.miguegea.pokemoncompanion.character.application.usecase.port.in;

import com.miguegea.pokemoncompanion.character.domain.model.CharacterSearchResult;

public interface SearchCharacterUseCase {

    CharacterSearchResult search(String characterName);
}
