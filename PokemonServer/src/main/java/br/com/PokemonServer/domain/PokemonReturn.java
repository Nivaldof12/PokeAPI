package br.com.PokemonServer.domain;

import java.util.List;

// A classe representa uma resposta contendo uma lista de Pokémon
public class PokemonReturn {
    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
