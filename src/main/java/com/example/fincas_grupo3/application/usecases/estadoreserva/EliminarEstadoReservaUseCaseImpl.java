package com.example.fincas_grupo3.application.usecases.estadoreserva;

import com.example.fincas_grupo3.domain.ports.in.estadoreserva.EliminarEstadoReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadoreserva.EstadoReservaOutPort;
import org.springframework.stereotype.Component;

@Component
public class EliminarEstadoReservaUseCaseImpl implements EliminarEstadoReservaUseCase {
    private final EstadoReservaOutPort estadoReservaOutPort;

    public EliminarEstadoReservaUseCaseImpl(EstadoReservaOutPort estadoReservaOutPort) {
        this.estadoReservaOutPort = estadoReservaOutPort;
    }

    @Override
    public boolean eliminarEstadoReservaPorId(Long id) {
        return estadoReservaOutPort.deleteById(id);
    }
}