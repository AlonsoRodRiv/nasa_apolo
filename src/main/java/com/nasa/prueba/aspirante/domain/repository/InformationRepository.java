package com.nasa.prueba.aspirante.domain.repository;

import com.nasa.prueba.aspirante.domain.entities.Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface InformationRepository extends JpaRepository<Information, Long> {
    boolean existsByNasaId(String nasaId);

    // Nuevo método para obtener todos los registros ordenados por ID de forma descendente
    List<Information> findAllByOrderByIdDesc();
}
