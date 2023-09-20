package br.com.PokemonServer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.PokemonServer.domain.Pokemon;
import br.com.PokemonServer.repository.PokemonRepository;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    // Método para obter todos os nomes de Pokémon
    public List<String> getTodosPokemon() {
        List<Pokemon> todosPokemons = pokemonRepository.getTodosPokemons();
        List<String> nomes = new ArrayList<>(todosPokemons.size());

        for (Pokemon pokemon : todosPokemons) {
        	nomes.add(pokemon.getName());
        }

        return nomes;
    }

    // Método para pesquisar por nome e não diferencia Maiúsculo de Minúsculo
    public List<String> getPesquisarPorPokemon(String nome) {
        final String pesquisarPorNome = nome.toLowerCase();
        List<Pokemon> todosPokemons = pokemonRepository.getTodosPokemons();
        List<String> nomes = new ArrayList<>();

        for (Pokemon pokemon : todosPokemons) {
            if (pokemon.getName().startsWith(pesquisarPorNome)) {
            	nomes.add(pokemon.getName());
            }
        }

        return nomes;
    }
    
    /** 
     * BigΩ: sortPokemonsPorOrdemAlfabetica
     * O BigΩ deste algoritmo de classificação é O(n²).
     * Isso significa que ele é pouco eficiente para listas maiores
     * mas como não é o caso, serve perfeitamente.
     */  
    // Método para listar nomes de Pokémons em ordem alfabética
    public List<String> sortPokemonsPorOrdemAlfabetica(List<String> nomes) {
        int n = nomes.size();
        boolean trocar;
        do {
        	trocar = false;
            for (int i = 1; i < n; i++) {
                if (nomes.get(i - 1).compareTo(nomes.get(i)) > 0) {
                    // Troca os elementos se estiverem fora de ordem
                    String temp = nomes.get(i - 1);
                    nomes.set(i - 1, nomes.get(i));
                    nomes.set(i, temp);
                    trocar = true;
                }
            }
        } while (trocar);
        return nomes;
    }
    
    /** 
     * BigΩ: sortPokemonsPorComprimento
     * O BigΩ deste algoritmo de classificação é O(n²). 
     * Como esse algoritmo não recebe um grande volume de dados
     * não é necessario um algoritmo de ordenação mais eficiente.
     */
 // lista nomes de Pokémons por comprimento
    public List<String> sortPokemonsPorComprimento(List<String> nomes) {
        int n = nomes.size();
        boolean trocar;
        do {
        	trocar = false;
            for (int i = 1; i < n; i++) {
                if (nomes.get(i - 1).length() > nomes.get(i).length()) {
                    // Troca os elementos se estiverem fora de ordem
                    String temp = nomes.get(i - 1);
                    nomes.set(i - 1, nomes.get(i));
                    nomes.set(i, temp);
                    trocar = true;
                }
            }
        } while (trocar);
        return nomes;
    }
}