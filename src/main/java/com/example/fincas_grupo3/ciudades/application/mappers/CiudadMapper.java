package com.example.fincas_grupo3.ciudades.application.mappers;

import com.example.fincas_grupo3.ciudades.application.dto.CiudadRequestDTO;
import com.example.fincas_grupo3.ciudades.application.dto.CiudadResponseDTO;
import com.example.fincas_grupo3.ciudades.domain.models.Ciudad;
import org.springframework.stereotype.Component;

@Component
public class CiudadMapper {

    public static Ciudad toModel(CiudadRequestDTO dto) {
        return new Ciudad(dto.getId(), dto.getNombre());
    }

    public static CiudadResponseDTO toDTO(Ciudad ciudad) {
        return new CiudadResponseDTO(ciudad.getId(), ciudad.getNombre());
    }
}
