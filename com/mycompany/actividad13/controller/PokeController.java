package com.mycompany.actividad13.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.mycompany.actividad13.domain.Pokemon;

import java.util.Collections;
import java.util.HashMap;

@RestController
@CrossOrigin("*")
public class PokeController {
    
    HttpEntity<String> entity = getHeaders();
    RestTemplate restTemplate;

    private PokeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String getURI(String pokemonName) {
        return "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
    }

    private HashMap<String, Object> createHashMap(String key, Object value) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    private HttpEntity<String> getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new HttpEntity<>(httpHeaders);
    }

    private Pokemon getPokemon(String pokemonName) {
        return restTemplate.exchange(getURI(pokemonName), HttpMethod.GET, entity, Pokemon.class).getBody();
    }

    @GetMapping("/id/{pokemon}")
    public ResponseEntity<Object> getPokemonId(@PathVariable("pokemon") String pokemonName) {
        return ResponseEntity.ok().body(createHashMap("id", getPokemon(pokemonName).getId()));
    }

    @GetMapping("/name/{pokemon}")
    public ResponseEntity<Object> getPokemonName(@PathVariable("pokemon") String pokemonName) {
        return ResponseEntity.ok().body(createHashMap("name", getPokemon(pokemonName).getName()));
    }

    @GetMapping("/base_experience/{pokemon}")
    public ResponseEntity<Object> getPokemonBaseExperience(@PathVariable("pokemon") String pokemonName) {
        return ResponseEntity.ok().body(createHashMap("base_experience", getPokemon(pokemonName).getBaseExperience()));
    }

    @GetMapping("/abilities/{pokemon}")
    public ResponseEntity<Object> getPokemonAbilities(@PathVariable("pokemon") String pokemonName) {
        return ResponseEntity.ok().body(createHashMap("abilities", getPokemon(pokemonName).getAbilities()));
    }

    @GetMapping("/held_items/{pokemon}")
    public ResponseEntity<Object> getPokemonHeldItems(@PathVariable("pokemon") String pokemonName) {
        return ResponseEntity.ok().body(createHashMap("held_items", getPokemon(pokemonName).getHeldItems()));
    }

    @GetMapping("/location_area_encounters/{pokemon}")
    public ResponseEntity<Object> getpokemonLocationArea(@PathVariable("pokemon") String pokemonName) {
        return ResponseEntity.ok().body(createHashMap("location_area_encounters", getPokemon(pokemonName).getLocationAreaEncounters()));
    }

}