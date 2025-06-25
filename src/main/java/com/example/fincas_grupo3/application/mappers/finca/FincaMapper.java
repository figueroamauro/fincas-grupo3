package com.example.fincas_grupo3.application.mappers.finca;

import com.example.fincas_grupo3.application.dto.finca.FincaRequestDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",implementationName = "fincaMapperApplication")
public abstract class FincaMapper {

    public abstract Finca toModel(FincaRequestDTO dto);

    public abstract FincaResponseDTO toDTO(Finca finca);
}
