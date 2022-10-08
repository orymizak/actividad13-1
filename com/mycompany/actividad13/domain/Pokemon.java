package com.mycompany.actividad13.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pokemon {

    @JsonProperty("id")
    int id;

    @JsonProperty("name")
    String name;

    @JsonProperty("base_experience")
    int baseExperience;

    @JsonProperty("abilities")
    Object[] abilities;

    @JsonProperty("held_items")
    Object[] heldItems;

    @JsonProperty("location_area_encounters")
    String locationAreaEncounters;

}