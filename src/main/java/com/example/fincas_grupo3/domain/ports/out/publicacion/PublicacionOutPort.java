package com.example.fincas_grupo3.domain.ports.out.publicacion;

import com.example.fincas_grupo3.domain.models.publicacion.Publicacion;

import java.util.List;

public interface PublicacionOutPort {

    Publicacion guardar(Publicacion publicacion);

    Publicacion actualizar(Publicacion publicacion);

    List<Publicacion> obtenerTodas();

    Publicacion obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
