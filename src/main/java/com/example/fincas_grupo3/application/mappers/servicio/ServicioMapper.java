package com.example.fincas_grupo3.application.mappers.servicio;

import com.example.fincas_grupo3.application.dto.servicio.ServicioRequestDTO;
import com.example.fincas_grupo3.application.dto.servicio.ServicioResponseDTO;
import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "servicioMapperApplication")
public abstract class ServicioMapper {

    public abstract Servicio toModel(ServicioRequestDTO dto);

    public abstract ServicioResponseDTO toDTO(Servicio servicio);
}
