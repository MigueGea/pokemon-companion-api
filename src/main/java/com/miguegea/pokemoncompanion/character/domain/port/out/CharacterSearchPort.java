package com.miguegea.pokemoncompanion.character.domain.port.out;

import com.miguegea.pokemoncompanion.character.domain.model.CharacterSearchResult;

public interface CharacterSearchPort {

    CharacterSearchResult search(String characterName);
}
