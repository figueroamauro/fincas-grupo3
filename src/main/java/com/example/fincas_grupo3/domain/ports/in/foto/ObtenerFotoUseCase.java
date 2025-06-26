package com.example.fincas_grupo3.domain.ports.in.foto;

import com.example.fincas_grupo3.domain.models.foto.Foto;

import java.util.List;

public interface ObtenerFotoUseCase {
    List<Foto> obtenerFotos();

    Foto obtenerFotoPorId(Long id);
}
