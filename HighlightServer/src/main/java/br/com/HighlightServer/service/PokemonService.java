package br.com.HighlightServer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.HighlightServer.domain.DestaqueDTO;
import br.com.HighlightServer.domain.Pokemon;
import br.com.HighlightServer.repository.PokemonRepository;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }
    
    // Retorna uma lista do DTO com todos os Pokémons
    public List<DestaqueDTO> getTodosPokemonsHighlight() {
        List<Pokemon> TodosOsPokemons = pokemonRepository.getTodosPokemons();
        List<DestaqueDTO> destaqueDTO = new ArrayList<>();

        for (Pokemon pokemon : TodosOsPokemons) {
            String name = pokemon.getName();
            destaqueDTO.add(new DestaqueDTO(name, name));
        }

        return destaqueDTO;
    }
    
    // Retorna uma lista de DTO por consulta e método <pre></pre>
    public List<DestaqueDTO> getPokemonsPorConsulta(String consulta) {
        final String pesquisaNome = consulta.toLowerCase();
        List<Pokemon> todosPokemons = pokemonRepository.getTodosPokemons();
        List<DestaqueDTO> destaqueDTO = new ArrayList<>();

        for (Pokemon pokemon : todosPokemons) {
            String name = pokemon.getName().toLowerCase();
            if (name.startsWith(pesquisaNome)) {
                String highlightedNome = name.replaceFirst(pesquisaNome, "<pre>" + pesquisaNome + "</pre>");
                destaqueDTO.add(new DestaqueDTO(pokemon.getName(), highlightedNome));
            }
        }

        return destaqueDTO;
    }
    /** 
     * BigΩ: sortPokemonEmOrdemAlfabetica
     * O BigΩ deste algoritmo de classificação é O(n²).
     * Isso significa que ele é pouco eficiente para listas maiores
     * mas como não é o caso, serve perfeitamente.
     */    
    // Função para ordenar manualmente os Pokémon em ordem alfabética crescente pelo nome
    public void sortPokemonEmOrdemAlfabetica(List<DestaqueDTO> result) {
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i + 1; j < result.size(); j++) {
            	DestaqueDTO pokemon1 = result.get(i);
            	DestaqueDTO pokemon2 = result.get(j);

                if (pokemon1.getName().compareToIgnoreCase(pokemon2.getName()) > 0) {
                    // Troca os Pokemons se estiverem fora de ordem
                    result.set(i, pokemon2);
                    result.set(j, pokemon1);
                }
            }
        }
    }
    
    /** 
     * BigΩ: sortPokemonPorComprimento
     * O BigΩ deste algoritmo de classificação é O(n²). 
     * Como esse algoritmo não recebe um grande volume de dados
     * não é necessario um algoritmo de ordenação mais eficiente.
     */   
    // Função para ordenar manualmente os Pokémon em destaque por comprimento do nome
    public void sortPokemonPorComprimento(List<DestaqueDTO> result) {
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i + 1; j < result.size(); j++) {
            	DestaqueDTO pokemon1 = result.get(i);
            	DestaqueDTO pokemon2 = result.get(j);

                if (pokemon1.getName().length() > pokemon2.getName().length()) {
                    // Troca os Pokémon se estiverem fora de ordem
                    result.set(i, pokemon2);
                    result.set(j, pokemon1);
                }
            }
        }
    }
}