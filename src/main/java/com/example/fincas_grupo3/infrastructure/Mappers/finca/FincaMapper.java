package com.example.fincas_grupo3.infrastructure.Mappers.finca;

import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.infrastructure.entities.finca.FincaEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",implementationName = "fincaMapperInfra")
public abstract class FincaMapper {

    public abstract Finca toModel(FincaEntidad entidad);

    public abstract FincaEntidad toEntity(Finca finca);
}
