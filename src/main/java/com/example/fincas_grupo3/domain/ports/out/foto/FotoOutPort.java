package com.example.fincas_grupo3.domain.ports.out.foto;

import com.example.fincas_grupo3.domain.models.foto.Foto;

import java.util.List;

public interface FotoOutPort {
    Foto guardar(Foto foto);

    List<Foto> obtenerTodas();

    Foto obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
