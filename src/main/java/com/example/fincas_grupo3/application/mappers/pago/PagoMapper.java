package com.example.fincas_grupo3.application.mappers.pago;

import com.example.fincas_grupo3.application.dto.pago.PagoRequestDTO;
import com.example.fincas_grupo3.application.dto.pago.PagoResponseDTO;
import com.example.fincas_grupo3.application.exceptions.EstadoPagoNoEncontradoException;
import com.example.fincas_grupo3.application.exceptions.ReservaNoEncontradaException;
import com.example.fincas_grupo3.application.mappers.reserva.ReservaMapper;
import com.example.fincas_grupo3.application.usecases.estadoPago.EstadoPagoUseCases;
import com.example.fincas_grupo3.application.usecases.reserva.ReservaUseCases;
import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;
import com.example.fincas_grupo3.domain.models.pago.Pago;
import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",
        uses = {ReservaMapper.class},
        implementationName = "pagoMapperApplication")
public abstract class PagoMapper {

    @Autowired
    protected EstadoPagoUseCases estadoPagoUseCases;
    @Autowired
    protected ReservaUseCases reservaUseCases;

    @Mapping(source = "estadoId", target = "estadoPago", qualifiedByName = "mapEstadoIdToEstadoPago")
    @Mapping(source = "reservaId", target = "reserva", qualifiedByName = "mapReservaIdToReserva")
    public abstract Pago toModel(PagoRequestDTO requestDTO);

    @Mapping(source = "estadoPago.nombre", target = "nombreEstado")
    @Mapping(source = "reserva", target = "reserva")
    public abstract PagoResponseDTO toDTO(Pago pago);

    @Named("mapEstadoIdToEstadoPago")
    protected EstadoPago mapEstadoIdToEstadoPago(Long estadoId) {
        EstadoPago estado = estadoPagoUseCases.obtenerEstadoPagoPorId(estadoId);
        if (estado == null) {
            throw new EstadoPagoNoEncontradoException("Estado de pago no encontrado con id: " + estadoId);
        }
        return estado;
    }

    @Named("mapReservaIdToReserva")
    protected Reserva mapReservaIdToReserva(Long reservaId) {
        Reserva reserva = reservaUseCases.obtenerReservaPorId(reservaId);
        if (reserva == null) {
            throw new ReservaNoEncontradaException("Reserva no encontrada con id: " + reservaId);
        }
        return reserva;
    }
}