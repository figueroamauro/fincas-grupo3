package com.example.fincas_grupo3.domain.ports.in.rol;

import com.example.fincas_grupo3.domain.models.rol.Rol;

import java.util.List;

public interface ObtenerRolUseCase {
    List<Rol> obtenerRoles();

    Rol obtenerRolPorId(Long id);
    Rol obtenerRol(String nombre);

}
