package br.com.HighlightServer.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.HighlightServer.domain.Pokemon;
import br.com.HighlightServer.domain.PokemonReturn;

@Repository
public class PokemonRepository {

    private final String apiUrl = "https://pokeapi.co/api/v2/pokemon/?offset=0&limit=100000";

    // Método para obter todos os Pokémon da API
    public List<Pokemon> getTodosPokemons() {
        RestTemplate restTemplate = new RestTemplate();
        PokemonReturn response = restTemplate.getForObject(apiUrl, PokemonReturn.class);
        return response.getResults();
    }
}
