package com.example.fincas_grupo3.domain.ports.out.estadopublicacion;

import com.example.fincas_grupo3.domain.models.estadopublicacion.EstadoPublicacion;

import java.util.List;


public interface EstadoPublicacionOutPort {

    EstadoPublicacion guardar(EstadoPublicacion estadoPublicacion);

    EstadoPublicacion actualizar(EstadoPublicacion estadoPublicacion);

    List<EstadoPublicacion> obtenerTodas();

    EstadoPublicacion obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
