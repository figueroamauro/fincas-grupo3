package com.example.fincas_grupo3.domain.ports.in.direccion;

import com.example.fincas_grupo3.application.dto.usuario.UsuarioRequestDTO;
import com.example.fincas_grupo3.domain.models.direccion.Direccion;

import java.util.List;

public interface ObtenerDireccionUseCase {
    List<Direccion> obtenerDirecciones();


    Direccion obtenerDireccionPorId(Long id);
}
