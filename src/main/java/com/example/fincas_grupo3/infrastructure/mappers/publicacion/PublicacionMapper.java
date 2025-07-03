package com.example.fincas_grupo3.infrastructure.mappers.publicacion;

import com.example.fincas_grupo3.domain.models.publicacion.Publicacion;
import com.example.fincas_grupo3.infrastructure.entities.publicacion.PublicacionEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "publicacionMapperInfra")
public abstract class PublicacionMapper {

    public abstract Publicacion toModel(PublicacionEntidad publicacionEntidad);

    public abstract PublicacionEntidad toEntity(Publicacion publicacion);
}