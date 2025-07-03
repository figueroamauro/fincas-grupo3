package com.example.fincas_grupo3.infrastructure.mappers.estadopublicacion;

import com.example.fincas_grupo3.domain.models.estadopublicacion.EstadoPublicacion;
import com.example.fincas_grupo3.infrastructure.entities.estadopublicacion.EstadoPublicacionEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstadoPublicacionMapper {

    EstadoPublicacionEntidad toEntity(EstadoPublicacion estadoPublicacion);

    EstadoPublicacion toModel(EstadoPublicacionEntidad estadoPublicacionEntidad);
}
