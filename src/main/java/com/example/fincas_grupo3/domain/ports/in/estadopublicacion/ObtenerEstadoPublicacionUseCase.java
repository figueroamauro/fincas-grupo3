package com.example.fincas_grupo3.domain.ports.in.estadopublicacion;

import com.example.fincas_grupo3.domain.models.estadopublicacion.EstadoPublicacion;

import java.util.List;

public interface ObtenerEstadoPublicacionUseCase {

    EstadoPublicacion obtenerEstadoPublicacionPorId(Long id);

    List<EstadoPublicacion> obtenerEstadoPublicaciones();
}
