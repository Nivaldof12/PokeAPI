package br.com.PokemonServer.domain;

import java.util.List;

public class PokemonDTO {
    private List<String> result; // Lista de nomes de Pokémon

    public PokemonDTO(List<String> result) {
        this.result = result;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
