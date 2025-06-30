package com.example.fincas_grupo3.domain.ports.out.ciudad;

import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;

import java.util.List;

public interface CiudadOutPort {

    Ciudad crearCiudad(Ciudad ciudad);

    Ciudad actualizarCiudad(Ciudad ciudad);

    List<Ciudad> obtenerCiudad();

    Ciudad obtenerCiudadPorId(Long id);

    Boolean eliminarCiudad(Ciudad ciudad);

    Boolean eliminarCiudadPorId(Long id);

}
