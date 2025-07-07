package com.example.fincas_grupo3.application.usecases.estadoreserva;

import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import com.example.fincas_grupo3.domain.ports.in.estadoreserva.ObtenerEstadoReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadoreserva.EstadoReservaOutPort;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ObtenerEstadoReservaUseCaseImpl implements ObtenerEstadoReservaUseCase {
    private final EstadoReservaOutPort estadoReservaOutPort;

    public ObtenerEstadoReservaUseCaseImpl(EstadoReservaOutPort estadoReservaOutPort) {
        this.estadoReservaOutPort = estadoReservaOutPort;
    }

    @Override
    public EstadoReserva obtenerEstadoReservaPorId(Long id) {
        return estadoReservaOutPort.findById(id);
    }

    @Override
    public List<EstadoReserva> obtenerTodosLosEstadosReserva() {
        return estadoReservaOutPort.findAll();
    }
}