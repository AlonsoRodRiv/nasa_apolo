package com.nasa.prueba.aspirante.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record CollectionDTO(
        @JsonAlias("items")
        List<ItemDTO> listItems
) {
}
