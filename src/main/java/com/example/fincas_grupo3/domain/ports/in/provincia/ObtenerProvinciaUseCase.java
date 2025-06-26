package com.example.fincas_grupo3.domain.ports.in.provincia;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;

import java.util.List;

public interface ObtenerProvinciaUseCase {

    Provincia obtenerProvinciaPorId(Long id);

    List<Provincia> obtenerProvincias();
}
