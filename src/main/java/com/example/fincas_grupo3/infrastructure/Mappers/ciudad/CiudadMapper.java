package com.example.fincas_grupo3.infrastructure.Mappers.ciudad;

import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import com.example.fincas_grupo3.infrastructure.entities.ciudad.CiudadEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "ciudadMapperInfra")
public abstract class CiudadMapper {

    public abstract CiudadEntidad toEntity(Ciudad ciudad);

    public abstract Ciudad toModel(CiudadEntidad ciudadEntidad);
}
