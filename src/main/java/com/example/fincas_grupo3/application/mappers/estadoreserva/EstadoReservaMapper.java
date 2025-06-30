package com.example.fincas_grupo3.application.mappers.estadoreserva;

import com.example.fincas_grupo3.application.dto.estadoreserva.EstadoReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.estadoreserva.EstadoReservaResponseDTO;
import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "estadoReservaMapperApplication")
public abstract class EstadoReservaMapper {
    public abstract EstadoReserva toModel(EstadoReservaRequestDTO requestDTO);
    public abstract EstadoReservaResponseDTO toDTO(EstadoReserva estadoReserva);
}