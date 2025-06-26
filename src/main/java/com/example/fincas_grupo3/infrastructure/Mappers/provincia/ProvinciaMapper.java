package com.example.fincas_grupo3.infrastructure.Mappers.provincia;


import com.example.fincas_grupo3.domain.models.provincia.Provincia;
import com.example.fincas_grupo3.infrastructure.entities.provincia.ProvinciaEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",implementationName = "provinciaMapperInfra")
public abstract class ProvinciaMapper {

    public abstract Provincia toModel(ProvinciaEntidad entidad);

    public abstract ProvinciaEntidad toEntity(Provincia provincia);
}
