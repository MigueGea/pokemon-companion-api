package com.miguegea.pokemoncompanion.character.domain.model;

import java.util.List;

public record CharacterSearchResult(List<Character> characters, int totalResults, int page, int pageSize) {
}
