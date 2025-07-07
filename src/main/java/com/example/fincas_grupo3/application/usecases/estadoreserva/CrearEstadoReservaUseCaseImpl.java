package com.example.fincas_grupo3.application.usecases.estadoreserva;

import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import com.example.fincas_grupo3.domain.ports.in.estadoreserva.CrearEstadoReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadoreserva.EstadoReservaOutPort;
import org.springframework.stereotype.Component;

@Component
public class CrearEstadoReservaUseCaseImpl implements CrearEstadoReservaUseCase {
    private final EstadoReservaOutPort estadoReservaOutPort;

    public CrearEstadoReservaUseCaseImpl(EstadoReservaOutPort estadoReservaOutPort) {
        this.estadoReservaOutPort = estadoReservaOutPort;
    }

    @Override
    public EstadoReserva crearEstadoReserva(EstadoReserva estadoReserva) {
        return estadoReservaOutPort.save(estadoReserva);
    }
}