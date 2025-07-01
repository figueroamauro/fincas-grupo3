package com.example.fincas_grupo3.application.usecases.estadopublicacion;

import com.example.fincas_grupo3.domain.models.estadopublicacion.EstadoPublicacion;
import com.example.fincas_grupo3.domain.ports.in.estadopublicacion.CrearEstadoPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadopublicacion.EstadoPublicacionOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearEstadoPublicacionUseCaseImpl implements CrearEstadoPublicacionUseCase {

    private final EstadoPublicacionOutPort estadoPublicacionOutPort;

    public CrearEstadoPublicacionUseCaseImpl(EstadoPublicacionOutPort estadoPublicacionOutPort) {
        this.estadoPublicacionOutPort = estadoPublicacionOutPort;
    }

    @Override
    public EstadoPublicacion crearEstadoPublicacion(EstadoPublicacion estadoPublicacion) {
        return estadoPublicacionOutPort.guardar(estadoPublicacion);
    }
}
