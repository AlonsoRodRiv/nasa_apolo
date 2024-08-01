package com.nasa.prueba.aspirante.mappers;

import com.nasa.prueba.aspirante.domain.dto.DataDTO;
import com.nasa.prueba.aspirante.domain.dto.InformationDTO;
import com.nasa.prueba.aspirante.domain.dto.ItemDTO;
import com.nasa.prueba.aspirante.domain.entities.Information;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InformationMapper {
    public List<Information> convertToInformationList(InformationDTO informationDTO) {
        List<Information> informationList = new ArrayList<>();
        if (informationDTO != null && informationDTO.collection() != null && informationDTO.collection().listItems() != null) {
            for (ItemDTO item : informationDTO.collection().listItems()) {
                if (item.listData() != null && !item.listData().isEmpty()) {
                    DataDTO data = item.listData().get(0);
                    Information information = new Information();
                    information.setHref(item.href());
                    information.setCenter(data.center());
                    information.setTitle(data.title());
                    information.setNasaId(data.nasa_id());
                    informationList.add(information);
                }
            }
        }
        return informationList;
    }
}
