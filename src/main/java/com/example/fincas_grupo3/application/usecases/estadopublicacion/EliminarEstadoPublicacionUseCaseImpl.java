package com.example.fincas_grupo3.application.usecases.estadopublicacion;

import com.example.fincas_grupo3.domain.ports.in.estadopublicacion.EliminarEstadoPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadopublicacion.EstadoPublicacionOutPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarEstadoPublicacionUseCaseImpl implements EliminarEstadoPublicacionUseCase {
    private final EstadoPublicacionOutPort estadoPublicacionOutPort;

    public EliminarEstadoPublicacionUseCaseImpl(EstadoPublicacionOutPort estadoPublicacionOutPort) {
        this.estadoPublicacionOutPort = estadoPublicacionOutPort;
    }

    @Override
    public Boolean eliminarEstadoPublicacionPorId(Long id) {
        return estadoPublicacionOutPort.eliminarPorId(id);
    }
}
