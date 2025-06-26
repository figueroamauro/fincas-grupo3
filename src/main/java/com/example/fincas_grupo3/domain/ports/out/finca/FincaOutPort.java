package com.example.fincas_grupo3.domain.ports.out.finca;

import com.example.fincas_grupo3.domain.models.finca.Finca;

import java.util.List;

public interface FincaOutPort {
    Finca guardar(Finca finca);

    Finca actualizar(Finca finca);

    List<Finca> obetenerTodas();

    Finca obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
