package com.nasa.prueba.aspirante.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataDTO(
        @JsonProperty("center")
        String center,
        @JsonProperty("title")
        String title,
        @JsonProperty("nasa_id")
         String nasa_id
) {
}
