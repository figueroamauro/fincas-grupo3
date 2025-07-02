package com.example.fincas_grupo3.application.usecases.estadopublicacion;

import com.example.fincas_grupo3.domain.models.estadopublicacion.EstadoPublicacion;
import com.example.fincas_grupo3.domain.ports.in.estadopublicacion.ActualizarEstadoPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.in.estadopublicacion.CrearEstadoPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.in.estadopublicacion.EliminarEstadoPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.in.estadopublicacion.ObtenerEstadoPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.in.estadopublicacion.EstadoPublicacionInPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoPublicacionUseCases implements EstadoPublicacionInPort {

    private final CrearEstadoPublicacionUseCase crearEstadoPublicacionUseCase;
    private final ActualizarEstadoPublicacionUseCase actualizarEstadoPublicacionUseCase;
    private final EliminarEstadoPublicacionUseCase eliminarEstadoPublicacionUseCase;
    private final ObtenerEstadoPublicacionUseCase obtenerEstadoPublicacionUseCase;

    public EstadoPublicacionUseCases(
            CrearEstadoPublicacionUseCase crearEstadoPublicacionUseCase,
            ActualizarEstadoPublicacionUseCase actualizarEstadoPublicacionUseCase,
            EliminarEstadoPublicacionUseCase eliminarEstadoPublicacionUseCase,
            ObtenerEstadoPublicacionUseCase obtenerEstadoPublicacionUseCase
    ) {
        this.crearEstadoPublicacionUseCase = crearEstadoPublicacionUseCase;
        this.actualizarEstadoPublicacionUseCase = actualizarEstadoPublicacionUseCase;
        this.eliminarEstadoPublicacionUseCase = eliminarEstadoPublicacionUseCase;
        this.obtenerEstadoPublicacionUseCase = obtenerEstadoPublicacionUseCase;
    }

    @Override
    public EstadoPublicacion crearEstadoPublicacion(EstadoPublicacion estadoPublicacion) {
        return crearEstadoPublicacionUseCase.crearEstadoPublicacion(estadoPublicacion);
    }

    @Override
    public EstadoPublicacion actualizarEstadoPublicacion(EstadoPublicacion estadoPublicacion) {
        return actualizarEstadoPublicacionUseCase.actualizarEstadoPublicacion(estadoPublicacion);
    }

    @Override
    public Boolean eliminarEstadoPublicacionPorId(Long id) {
        return eliminarEstadoPublicacionUseCase.eliminarEstadoPublicacionPorId(id);
    }

    @Override
    public EstadoPublicacion obtenerEstadoPublicacionPorId(Long id) {
        return obtenerEstadoPublicacionUseCase.obtenerEstadoPublicacionPorId(id);
    }

    @Override
    public List<EstadoPublicacion> obtenerEstadoPublicaciones() {
        return obtenerEstadoPublicacionUseCase.obtenerEstadoPublicaciones();
    }


    public EstadoPublicacion guardar(EstadoPublicacion estadoPublicacion) {
        return crearEstadoPublicacion(estadoPublicacion);
    }


    public List<EstadoPublicacion> obtenerTodos() {
        return obtenerEstadoPublicaciones();
    }
}
