package com.example.fincas_grupo3.application.usecases.estadopublicacion;

import com.example.fincas_grupo3.domain.models.estadopublicacion.EstadoPublicacion;
import com.example.fincas_grupo3.domain.ports.in.estadopublicacion.ObtenerEstadoPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadopublicacion.EstadoPublicacionOutPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerEstadoPublicacionUseCaseImpl implements ObtenerEstadoPublicacionUseCase {

    private final EstadoPublicacionOutPort estadoPublicacionOutPort;

    public ObtenerEstadoPublicacionUseCaseImpl(EstadoPublicacionOutPort estadoPublicacionOutPort) {
        this.estadoPublicacionOutPort = estadoPublicacionOutPort;
    }

    @Override
    public EstadoPublicacion obtenerEstadoPublicacionPorId(Long id) {
        return estadoPublicacionOutPort.obtenerPorId(id);
    }

    @Override
    public List<EstadoPublicacion> obtenerEstadoPublicaciones() {
        return estadoPublicacionOutPort.obtenerTodas();
    }
}
