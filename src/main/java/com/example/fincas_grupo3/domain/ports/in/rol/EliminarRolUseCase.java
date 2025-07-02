package com.example.fincas_grupo3.domain.ports.in.rol;

public interface EliminarRolUseCase {
    boolean eliminarRolPorId(Long id);
    boolean eliminarRol(String nombre);
}
