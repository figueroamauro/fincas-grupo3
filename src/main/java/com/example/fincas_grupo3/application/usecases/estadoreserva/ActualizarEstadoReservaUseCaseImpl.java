package com.example.fincas_grupo3.application.usecases.estadoreserva;

import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import com.example.fincas_grupo3.domain.ports.in.estadoreserva.ActualizarEstadoReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadoreserva.EstadoReservaOutPort;
import org.springframework.stereotype.Component;

@Component
public class ActualizarEstadoReservaUseCaseImpl implements ActualizarEstadoReservaUseCase {
    private final EstadoReservaOutPort estadoReservaOutPort;

    public ActualizarEstadoReservaUseCaseImpl(EstadoReservaOutPort estadoReservaOutPort) {
        this.estadoReservaOutPort = estadoReservaOutPort;
    }

    @Override
    public EstadoReserva actualizarEstadoReserva(EstadoReserva estadoReserva) {
        return estadoReservaOutPort.update(estadoReserva);
    }
}