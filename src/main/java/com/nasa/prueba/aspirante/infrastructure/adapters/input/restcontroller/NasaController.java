package com.nasa.prueba.aspirante.infrastructure.adapters.input.restcontroller;

import com.nasa.prueba.aspirante.aplication.services.InformationService;
import com.nasa.prueba.aspirante.domain.dto.InformationDTO;
import com.nasa.prueba.aspirante.domain.entities.Information;
import com.nasa.prueba.aspirante.infrastructure.clientrest.ExternalServiceAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NasaController {
    private final ExternalServiceAdapter externalServiceAdapter;
    private final InformationService informationService;

    public NasaController(ExternalServiceAdapter externalServiceAdapter, InformationService informationService) {
        this.externalServiceAdapter = externalServiceAdapter;
        this.informationService = informationService;
    }
    @GetMapping("search/{name}")
    public InformationDTO getInformation(@PathVariable String name) {
        return externalServiceAdapter.searchInformation(name);
}
    @GetMapping("/data")
    public List<Information> getAllData() {
        return informationService.getAllInformationOrderedByIdDesc();
    }
}
