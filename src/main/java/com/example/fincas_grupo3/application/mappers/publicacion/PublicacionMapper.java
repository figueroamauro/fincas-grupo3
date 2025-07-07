package com.example.fincas_grupo3.application.mappers.publicacion;

import com.example.fincas_grupo3.application.dto.publicacion.PublicacionRequestDTO;
import com.example.fincas_grupo3.application.dto.publicacion.PublicacionResponseDTO;
import com.example.fincas_grupo3.domain.models.publicacion.Publicacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "publicacionMapperApplication")
public abstract class PublicacionMapper {

    public abstract Publicacion toModel(PublicacionRequestDTO dto);

    public abstract PublicacionResponseDTO toDTO(Publicacion model);
}

