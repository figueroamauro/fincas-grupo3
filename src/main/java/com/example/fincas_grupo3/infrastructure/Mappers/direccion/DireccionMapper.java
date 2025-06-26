package com.example.fincas_grupo3.infrastructure.Mappers.direccion;

import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.infrastructure.entities.direccion.DireccionEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "direccionMapperInfra")
public abstract class DireccionMapper {

    public abstract Direccion toModel(DireccionEntidad entidad);

    public abstract DireccionEntidad toEntity(Direccion direccion);
}