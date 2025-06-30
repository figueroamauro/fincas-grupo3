package com.example.fincas_grupo3.application.usecases.estadoreserva;

import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import com.example.fincas_grupo3.domain.ports.in.estadoreserva.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoReservaUseCases implements EstadoReservaInPort {

    private final CrearEstadoReservaUseCase crearEstadoReservaUseCase;
    private final ObtenerEstadoReservaUseCase obtenerEstadoReservaUseCase;
    private final ActualizarEstadoReservaUseCase actualizarEstadoReservaUseCase;
    private final EliminarEstadoReservaUseCase eliminarEstadoReservaUseCase;

    public EstadoReservaUseCases(CrearEstadoReservaUseCase crearEstadoReservaUseCase,
                                 ObtenerEstadoReservaUseCase obtenerEstadoReservaUseCase,
                                 ActualizarEstadoReservaUseCase actualizarEstadoReservaUseCase,
                                 EliminarEstadoReservaUseCase eliminarEstadoReservaUseCase) {
        this.crearEstadoReservaUseCase = crearEstadoReservaUseCase;
        this.obtenerEstadoReservaUseCase = obtenerEstadoReservaUseCase;
        this.actualizarEstadoReservaUseCase = actualizarEstadoReservaUseCase;
        this.eliminarEstadoReservaUseCase = eliminarEstadoReservaUseCase;
    }

    @Override
    public EstadoReserva crearEstadoReserva(EstadoReserva estadoReserva) {
        return crearEstadoReservaUseCase.crearEstadoReserva(estadoReserva);
    }

    @Override
    public EstadoReserva obtenerEstadoReservaPorId(Long id) {
        return obtenerEstadoReservaUseCase.obtenerEstadoReservaPorId(id);
    }

    @Override
    public List<EstadoReserva> obtenerTodosLosEstadosReserva() {
        return obtenerEstadoReservaUseCase.obtenerTodosLosEstadosReserva();
    }

    @Override
    public EstadoReserva actualizarEstadoReserva(EstadoReserva estadoReserva) {
        return actualizarEstadoReservaUseCase.actualizarEstadoReserva(estadoReserva);
    }

    @Override
    public boolean eliminarEstadoReservaPorId(Long id) {
        return eliminarEstadoReservaUseCase.eliminarEstadoReservaPorId(id);
    }
}