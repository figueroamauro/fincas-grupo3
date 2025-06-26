package com.example.fincas_grupo3.application.mappers.direccion;

import com.example.fincas_grupo3.application.dto.direccion.DireccionRequestDTO;
import com.example.fincas_grupo3.application.dto.direccion.DireccionResponseDTO;
import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",implementationName = "direccionMapperApplication")
public abstract class DireccionMapper {

    public abstract Direccion toModel(DireccionRequestDTO dto);

    public abstract DireccionResponseDTO toDTO(Direccion direccion);
}
