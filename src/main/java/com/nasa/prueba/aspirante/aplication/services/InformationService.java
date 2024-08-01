package com.nasa.prueba.aspirante.aplication.services;

import com.nasa.prueba.aspirante.domain.entities.Information;
import com.nasa.prueba.aspirante.domain.repository.InformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationService {
    private final InformationRepository informationRepository;

    public InformationService(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    public List<Information> getAllInformationOrderedByIdDesc() {
        return informationRepository.findAllByOrderByIdDesc();
    }
}
