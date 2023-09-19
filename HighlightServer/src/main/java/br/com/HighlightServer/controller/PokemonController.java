package br.com.HighlightServer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.HighlightServer.domain.DestaqueDTO;
import br.com.HighlightServer.domain.DestaqueReturn;
import br.com.HighlightServer.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }
    
    // Retorna todos os Pokémons e highlight
    @GetMapping("/highlight")
    public DestaqueReturn getTodosOsPokemonsHighlight() {
        List<DestaqueDTO> nomes = pokemonService.getTodosPokemonsHighlight();
        return new DestaqueReturn(nomes);
    }
    
    // Retorna todos os Pokémon em ordem alfabética
    @GetMapping("/highlight/ordenar")
    public DestaqueReturn getTodosOsPokemonsEmOrdemAlfabetica() {
        List<String> names = pokemonService.getBuscarTodosPokemons();
        pokemonService.sortOrdenarLista(names);
        
        List<DestaqueDTO> result = new ArrayList<>();
        for (String name : names) {
            result.add(new DestaqueDTO(name, name));
        }
        
        return new DestaqueReturn(result);
    }
    
    // Retorna todos os Pokémon ordenados por comprimento do nome
    @GetMapping("/highlight/comprimento")
    public DestaqueReturn getTodosOsPokemonsPorTamanho() {
    	DestaqueReturn response = getTodosOsPokemonsHighlight();
        List<DestaqueDTO> result = response.getResult();
        pokemonService.sortPokemonPorComprimento(result);
        response.setResult(result);
        return response;
    }
    
    // Retorna uma consulta de Pokémons
    @GetMapping("/highlight/{consulta}")
    public DestaqueReturn getPokemonsConsulta(@PathVariable String consulta) {
        List<DestaqueDTO> result = pokemonService.getPokemonsPorConsulta(consulta);
        return new DestaqueReturn(result);
    }
    
    // Retorna uma consulta de Pokémons em ordem alfabética
    @GetMapping("/highlight/{consulta}/ordenar")
    public DestaqueReturn getPokemonsPorOrdemEConsulta(@PathVariable String consulta) {
    	DestaqueReturn response = getPokemonsConsulta(consulta);
        List<DestaqueDTO> result = response.getResult();
        pokemonService.sortPokemonEmOrdemAlfabetica(result);
        response.setResult(result);
        return response;
    }
    
    // Retorna uma consulta de Pokémons por comprimento do nome
    @GetMapping("/highlight/{consulta}/comprimento")
    public DestaqueReturn getPokemonsPorComprimentoEConsulta(@PathVariable String consulta) {
    	DestaqueReturn response = getPokemonsConsulta(consulta);
        List<DestaqueDTO> result = response.getResult();
        pokemonService.sortPokemonPorComprimento(result);
        response.setResult(result);
        return response;
    }
}
