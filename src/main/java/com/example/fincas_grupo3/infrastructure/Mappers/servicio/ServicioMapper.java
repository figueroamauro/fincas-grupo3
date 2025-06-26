package com.example.fincas_grupo3.infrastructure.Mappers.servicio;

import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import com.example.fincas_grupo3.infrastructure.entities.servicio.ServicioEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "servicioMapperInfra")
public abstract class ServicioMapper {

    public abstract Servicio toModel(ServicioEntidad entidad);

    public abstract ServicioEntidad toEntity(Servicio servicio);
}
