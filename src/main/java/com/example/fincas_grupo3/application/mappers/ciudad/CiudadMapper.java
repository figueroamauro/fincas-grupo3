package com.example.fincas_grupo3.application.mappers.ciudad;

import com.example.fincas_grupo3.application.dto.ciudad.CiudadRequestDTO;
import com.example.fincas_grupo3.application.dto.ciudad.CiudadResponseDTO;
import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
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
