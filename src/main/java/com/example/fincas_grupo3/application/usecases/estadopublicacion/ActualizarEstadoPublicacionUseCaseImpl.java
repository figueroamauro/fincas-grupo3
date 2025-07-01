package com.example.fincas_grupo3.application.usecases.estadopublicacion;

import com.example.fincas_grupo3.domain.models.estadopublicacion.EstadoPublicacion;
import com.example.fincas_grupo3.domain.ports.in.estadopublicacion.ActualizarEstadoPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadopublicacion.EstadoPublicacionOutPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarEstadoPublicacionUseCaseImpl implements ActualizarEstadoPublicacionUseCase {
    private final EstadoPublicacionOutPort estadoPublicacionOutPort;

    public ActualizarEstadoPublicacionUseCaseImpl(EstadoPublicacionOutPort estadoPublicacionOutPort) {
        this.estadoPublicacionOutPort = estadoPublicacionOutPort;
    }

    @Override
    public EstadoPublicacion actualizarEstadoPublicacion(EstadoPublicacion estadoPublicacion) {
        return estadoPublicacionOutPort.actualizar(estadoPublicacion);
    }
}
