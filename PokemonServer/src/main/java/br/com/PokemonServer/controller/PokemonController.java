package br.com.PokemonServer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.PokemonServer.domain.PokemonDTO;
import br.com.PokemonServer.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    // Obter todos os Pokémons
    @GetMapping
    public PokemonDTO getAllPokemons() {
        List<String> nomes = pokemonService.getTodosPokemon();
        return new PokemonDTO(nomes);
    }
    
    // Obter todos os Pokémons em ordem alfabética
    @GetMapping("/ordenar")
    public PokemonDTO getAllPokemonsOrdered() {
        List<String> nomes = pokemonService.sortPokemonsPorOrdemAlfabetica(pokemonService.getTodosPokemon());
        return new PokemonDTO(nomes);
    }
    
    // Obter todos os Pokémons em ordem por comprimento do nome
    @GetMapping("/comprimento")
    public PokemonDTO getAllPokemonsOrderedByLength() {
        List<String> nomes = pokemonService.sortPokemonsPorComprimento(pokemonService.getTodosPokemon());
        return new PokemonDTO(nomes);
    }

    // Endpoint para obter nomes de Pokémon por nome ou iniciais fornecidas
    @GetMapping("/{nome}")
    public PokemonDTO getPokemonsByFirstLetter(@PathVariable String nome) {
        List<String> nomes = pokemonService.getPesquisarPorPokemon(nome);
        return new PokemonDTO(nomes);
    }
    
    // Endpoint para obter nomes de Pokémon por nome ou iniciais fornecidas e em ordem alfabética
    @GetMapping("/{nome}/ordenar")
    public PokemonDTO getPokemonsByFirstLetterOrdered(@PathVariable String nome) {
        List<String> nomes = pokemonService.sortPokemonsPorOrdemAlfabetica(pokemonService.getPesquisarPorPokemon(nome));
        return new PokemonDTO(nomes);
    }
    
    // Endpoint para obter nomes de Pokémon por nome ou iniciais fornecidas e por comprimento do nome
    @GetMapping("/{nome}/comprimento")
    public PokemonDTO getPokemonsByFirstLetterOrderedByLength(@PathVariable String nome) {
        List<String> nomes = pokemonService.sortPokemonsPorComprimento(pokemonService.getPesquisarPorPokemon(nome));
        return new PokemonDTO(nomes);
    }
}
