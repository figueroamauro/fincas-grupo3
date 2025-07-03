package com.example.fincas_grupo3.application.mappers.finca;

import com.example.fincas_grupo3.application.dto.finca.FincaRequestDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.application.mappers.direccion.DireccionMapper;

import org.mapstruct.Mapper;
//Aca se mapea
@Mapper(
        componentModel = "spring",
        uses = {DireccionMapper.class},
        implementationName = "fincaMapperApplication"
)
public interface FincaMapper {
    Finca toModel(FincaRequestDTO dto);
    FincaResponseDTO toDTO(Finca finca);
}
