package com.example.fincas_grupo3.domain.ports.in.publicacion;

import com.example.fincas_grupo3.domain.models.publicacion.Publicacion;

import java.util.List;

public interface ObtenerPublicacionUseCase {

    Publicacion obtenerPublicacionPorId(Long id);

    List<Publicacion> obtenerPublicaciones();
}
