package com.example.fincas_grupo3.application.mappers.estadopublicacion;

import com.example.fincas_grupo3.application.dto.estadopublicacion.EstadoPublicacionResponseDTO;
import com.example.fincas_grupo3.application.dto.estadopublicacion.EstadoPublicacionRequestDTO;
import com.example.fincas_grupo3.domain.models.estadopublicacion.EstadoPublicacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "estadoPublicacionMapperApplication")
public abstract class EstadoPublicacionMapper {

    public abstract EstadoPublicacion toModel(EstadoPublicacionRequestDTO dto);

    public abstract EstadoPublicacionResponseDTO toDTO(EstadoPublicacion model);
}

