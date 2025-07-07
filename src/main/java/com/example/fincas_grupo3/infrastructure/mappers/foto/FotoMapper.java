package com.example.fincas_grupo3.infrastructure.mappers.foto;

import com.example.fincas_grupo3.domain.models.foto.Foto;
import com.example.fincas_grupo3.infrastructure.entities.foto.FotoEntidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationName = "fotoMapperInfra")
public abstract class FotoMapper {

    @Mapping(source = "finca", target = "finca", ignore = true)
    public abstract Foto toModel(FotoEntidad fotoEntidad);

    @Mapping(source = "finca", target = "finca")
    public abstract FotoEntidad toEntity(Foto foto);
}
