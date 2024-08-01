package com.nasa.prueba.aspirante.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ItemDTO(
        @JsonProperty("href")
       String href,
        @JsonProperty("data")
        List<DataDTO> listData
) {
}
