package com.example.fincas_grupo3.infrastructure.mappers.direccion;

import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.infrastructure.entities.direccion.DireccionEntidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationName = "direccionMapperInfra")
public abstract class DireccionMapper {

    @Mapping(source = "ciudadEntidad", target = "ciudad")
    public abstract Direccion toModel(DireccionEntidad entidad);

    @Mapping(source = "ciudad", target = "ciudadEntidad")
    public abstract DireccionEntidad toEntity(Direccion direccion);
}