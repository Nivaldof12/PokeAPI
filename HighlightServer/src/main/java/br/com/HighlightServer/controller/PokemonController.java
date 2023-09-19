package br.com.HighlightServer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.HighlightServer.domain.DestaqueDTO;
import br.com.HighlightServer.domain.DestaqueReturn;
import br.com.HighlightServer.service.PokemonService;

@RestController
@RequestMapping("/pokemon/highlight")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    // Endpoint para buscar nomes de Pokémon com opções de consulta, ordenação e comprimento
    @GetMapping
    public DestaqueReturn getPokemons(
        @RequestParam(name = "consulta", required = false) String consulta,
        @RequestParam(name = "ordenar", required = false) boolean ordenar,
        @RequestParam(name = "comprimento", required = false) boolean comprimento
    ) {
        List<DestaqueDTO> nomes;

        if (consulta != null) {
        	// Consulta para pesquisar Pokémons por nome ou iniciais
            nomes = pokemonService.getPokemonsPorConsulta(consulta);
        } else {
        	// Consultar Todos os Pokémons
            nomes = pokemonService.getTodosPokemonsHighlight();
        }

        if (ordenar) {
        	// Se ordenar for true os nomes devem ser ordenados em ordem alfabética
            pokemonService.sortPokemonEmOrdemAlfabetica(nomes);
        }

        if (comprimento) {
        	//Se comprimento for true os nomes devem ser ordenados por comprimento
            pokemonService.sortPokemonPorComprimento(nomes);
        }

        return new DestaqueReturn(nomes);
    }
}
