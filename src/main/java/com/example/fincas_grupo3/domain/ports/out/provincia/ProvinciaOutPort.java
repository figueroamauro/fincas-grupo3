package com.example.fincas_grupo3.domain.ports.out.provincia;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;

import java.util.List;

public interface ProvinciaOutPort {

    Provincia guardar(Provincia provincia);

    Provincia actualizar(Provincia provincia);

    List<Provincia> obtenerTodas();

    Provincia obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
