package br.com.PokemonServer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.PokemonServer.domain.PokemonDTO;
import br.com.PokemonServer.service.PokemonService;

@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    // Endpoint para buscar nomes de Pokémon com opções de consulta, ordenação e comprimento
    @GetMapping("/pokemon")
    public PokemonDTO getPokemons(
        @RequestParam(name = "consulta", required = false) String consulta,
        @RequestParam(name = "ordenar", required = false) boolean ordenar,
        @RequestParam(name = "comprimento", required = false) boolean comprimento
    ) {
        List<String> nomes;
        if (consulta != null) {
        	// Consulta para pesquisar Pokémons por nome ou iniciais
            nomes = pokemonService.getPesquisarPorPokemon(consulta);
        } else {
        	// Consultar Todos os Pokémons
            nomes = pokemonService.getTodosPokemon();
        }

        if (ordenar) {
        	// Se ordenar for true os nomes devem ser ordenados em ordem alfabética
            nomes = pokemonService.sortPokemonsPorOrdemAlfabetica(nomes);
        }

        if (comprimento) {
        	//Se comprimento for true os nomes devem ser ordenados por comprimento
            nomes = pokemonService.sortPokemonsPorComprimento(nomes);
        }

        return new PokemonDTO(nomes);
    }
}