package com.example.fincas_grupo3.domain.ports.out.rol;

import com.example.fincas_grupo3.domain.models.rol.Rol;

import java.util.List;

public interface RolOutPort {
    Rol obtenerRolPorId(Long id);

    boolean eliminarRolPorId(Long id);

    Rol obtenerRol(String nombre);

    List<Rol> obtenerRoles();

    Rol crearRol(Rol rol);

    boolean eliminarRol(String nombre);
}
