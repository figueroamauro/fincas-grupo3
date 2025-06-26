package com.example.fincas_grupo3.application.usecases.reserva;

import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import com.example.fincas_grupo3.domain.ports.in.reserva.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaUseCases implements ReservaInPort {

    private final CrearReservaUseCase crearReservaUseCase;
    private final ActualizarReservaUseCase actualizarReservaUseCase;
    private final EliminarReservaUseCase eliminarReservaUseCase;
    private final ObtenerReservaUseCase obtenerReservaUseCase;

    public ReservaUseCases(CrearReservaUseCase crearReservaUseCase, ActualizarReservaUseCase actualizarReservaUseCase, EliminarReservaUseCase eliminarReservaUseCase, ObtenerReservaUseCase obtenerReservaUseCase) {
        this.crearReservaUseCase = crearReservaUseCase;
        this.actualizarReservaUseCase = actualizarReservaUseCase;
        this.eliminarReservaUseCase = eliminarReservaUseCase;
        this.obtenerReservaUseCase = obtenerReservaUseCase;
    }

    @Override
    public Reserva crearReserva(Reserva reserva) {
        return crearReservaUseCase.crearReserva(reserva);
    }

    @Override
    public Reserva actualizarReserva(Reserva reserva) {
        return actualizarReservaUseCase.actualizarReserva(reserva);
    }

    @Override
    public Reserva obtenerReservaPorId(Long id) {
        return obtenerReservaUseCase.obtenerReservaPorId(id);
    }

    @Override
    public List<Reserva> obtenerReservas() {
        return obtenerReservaUseCase.obtenerReservas();
    }

    @Override
    public Boolean eliminarReserva(Reserva reserva) {
        return eliminarReservaUseCase.eliminarReserva(reserva);
    }

    @Override
    public Boolean eliminarReservaPorId(Long id) {
        return eliminarReservaUseCase.eliminarReservaPorId(id);
    }
}