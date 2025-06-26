package com.example.fincas_grupo3.infrastructure.Mappers.foto;

import com.example.fincas_grupo3.domain.models.foto.Foto;
import com.example.fincas_grupo3.infrastructure.entities.foto.FotoEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "fotoMapperInfra")
public abstract class FotoMapper {

    public abstract Foto toModel(FotoEntidad fotoEntidad);

    public abstract FotoEntidad toEntity(Foto foto);
}
