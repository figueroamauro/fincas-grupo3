package com.example.fincas_grupo3.application.mappers.reserva;

import com.example.fincas_grupo3.application.dto.reserva.ReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.reserva.ReservaResponseDTO;
import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "reservaMapperApplication")
public abstract class ReservaMapper {
    public abstract Reserva toModel(ReservaRequestDTO requestDTO);
    public abstract ReservaResponseDTO toDTO(Reserva reserva);
}