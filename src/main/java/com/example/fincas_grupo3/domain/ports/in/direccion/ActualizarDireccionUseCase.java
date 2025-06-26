package com.example.fincas_grupo3.domain.ports.in.direccion;

import com.example.fincas_grupo3.application.dto.usuario.UsuarioResponseDTO;
import com.example.fincas_grupo3.domain.models.direccion.Direccion;

public interface ActualizarDireccionUseCase {
    Direccion actualizarDireccion(Direccion direccion);
}
