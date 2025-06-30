package com.example.fincas_grupo3.application.mappers.ciudad;

import com.example.fincas_grupo3.application.dto.ciudad.CiudadRequestDTO;
import com.example.fincas_grupo3.application.dto.ciudad.CiudadResponseDTO;
import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", implementationName = "ciudadMapperApplication")
public abstract class CiudadMapper {

    public abstract Ciudad toModel(CiudadRequestDTO dto);

    public abstract CiudadResponseDTO toDTO(Ciudad ciudad);
}
