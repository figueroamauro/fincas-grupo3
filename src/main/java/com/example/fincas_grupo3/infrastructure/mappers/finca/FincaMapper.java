package com.example.fincas_grupo3.infrastructure.mappers.finca;

import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.infrastructure.entities.finca.FincaEntidad;
import com.example.fincas_grupo3.infrastructure.mappers.direccion.DireccionMapper;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {DireccionMapper.class},
        implementationName = "fincaMapperInfra"
)
public interface FincaMapper {

    Finca toModel(FincaEntidad entidad);

    FincaEntidad toEntity(Finca finca);
}
