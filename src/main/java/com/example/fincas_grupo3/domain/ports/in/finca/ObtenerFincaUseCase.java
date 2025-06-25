package com.example.fincas_grupo3.domain.ports.in.finca;

import com.example.fincas_grupo3.domain.models.finca.Finca;

import java.util.List;

public interface ObtenerFincaUseCase {
    List<Finca> obtenerFincas();

    Finca obtenerFincaPorId(Long id);
}
