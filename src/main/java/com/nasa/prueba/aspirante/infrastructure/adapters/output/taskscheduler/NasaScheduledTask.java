package com.nasa.prueba.aspirante.infrastructure.adapters.output.taskscheduler;

import com.nasa.prueba.aspirante.domain.dto.DataDTO;
import com.nasa.prueba.aspirante.domain.dto.InformationDTO;
import com.nasa.prueba.aspirante.domain.dto.ItemDTO;
import com.nasa.prueba.aspirante.domain.entities.Information;
import com.nasa.prueba.aspirante.domain.repository.InformationRepository;
import com.nasa.prueba.aspirante.infrastructure.clientrest.ExternalServiceAdapter;
import com.nasa.prueba.aspirante.mappers.InformationMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NasaScheduledTask {
    private final ExternalServiceAdapter externalServiceAdapter;
    private final InformationRepository informationRepository;
    private final InformationMapper informationMapper;
    private boolean isTaskCompleted = false;
    private boolean isFirstRun = true;

    public NasaScheduledTask(ExternalServiceAdapter externalServiceAdapter, InformationRepository informationRepository, InformationMapper informationMapper) {
        this.externalServiceAdapter = externalServiceAdapter;
        this.informationRepository = informationRepository;
        this.informationMapper = informationMapper;
    }

    @Scheduled(fixedRate = 60000) // Ejecutar cada minuto
    public void searchAndSaveApollo11Data() {
        if (isTaskCompleted) {
            if (isFirstRun) {
                System.out.println("La tarea ya fue ejecutada y completada en una ejecución anterior.");
                isFirstRun = false;
            }
            return;
        }

        InformationDTO informationDTO = externalServiceAdapter.searchInformation("apollo 11");
        List<Information> newInformationList = informationMapper.convertToInformationList(informationDTO);

        boolean newDataAdded = false;
        for (Information info : newInformationList) {
            if (!informationRepository.existsByNasaId(info.getNasaId())) {
                informationRepository.save(info);
                newDataAdded = true;
            }
        }

        if (!newDataAdded) {
            isTaskCompleted = true;
            System.out.println("Tarea completada: No hay más datos nuevos para agregar. Todos los datos han sido guardados en la base de datos.");
        } else {
            System.out.println("Se han agregado nuevos datos a la base de datos.");
        }
    }


}
