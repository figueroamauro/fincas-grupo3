package com.example.fincas_grupo3.domain.ports.out.direccion;

import com.example.fincas_grupo3.domain.models.direccion.Direccion;

import java.util.List;

public interface DireccionOutPort {

        Direccion guardar(Direccion direccion);

        Direccion actualizar(Direccion direccion);

        List<Direccion> obtenerTodas();

        Direccion obtenerPorId(Long id);

        Boolean eliminarPorId(Long id);

}
