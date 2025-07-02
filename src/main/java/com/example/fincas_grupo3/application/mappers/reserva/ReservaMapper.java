package com.example.fincas_grupo3.application.mappers.reserva;

import com.example.fincas_grupo3.application.dto.reserva.ReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.reserva.ReservaResponseDTO;
import com.example.fincas_grupo3.application.exceptions.EstadoReservaNoEncontradoException;
import com.example.fincas_grupo3.application.exceptions.ProvinciaNoEncontradaException;
import com.example.fincas_grupo3.application.usecases.estadoreserva.EstadoReservaUseCases;
import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import com.example.fincas_grupo3.domain.models.provincia.Provincia;
import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", implementationName = "reservaMapperApplication")
public abstract class ReservaMapper {

    @Autowired
    protected EstadoReservaUseCases estadoReservaUseCases;

    @Mapping(source = "estadoId", target = "estadoReserva", qualifiedByName = "mapEstadoIdToEstado")
    public abstract Reserva toModel(ReservaRequestDTO requestDTO);

    @Mapping(source = "estadoReserva.nombre", target = "nombreEstado")
    public abstract ReservaResponseDTO toDTO(Reserva reserva);

    @Named("mapEstadoIdToEstado")
    protected EstadoReserva mapEstadoIdToEstado(Long estadoId) {

        EstadoReserva estadoReserva = estadoReservaUseCases.obtenerEstadoReservaPorId(estadoId);
        if(estadoReserva == null) {
            throw new EstadoReservaNoEncontradoException("Estado reserva con id " + estadoId + " no encontrada.");
        }
        return estadoReserva;
    }
}