package com.example.fincas_grupo3.application.usecases.rol;

import com.example.fincas_grupo3.domain.models.rol.Rol;
import com.example.fincas_grupo3.domain.ports.in.rol.CrearRolUseCase;
import com.example.fincas_grupo3.domain.ports.in.rol.EliminarRolUseCase;
import com.example.fincas_grupo3.domain.ports.in.rol.ObtenerRolUseCase;
import com.example.fincas_grupo3.domain.ports.in.rol.RolInPort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolUseCases implements RolInPort {
    private final CrearRolUseCase crearRolUseCase;
    private final EliminarRolUseCase eliminarRolUseCase;
    private final ObtenerRolUseCase obtenerRolUseCase;
    public RolUseCases(CrearRolUseCase crearRolUseCase, EliminarRolUseCase eliminarRolUseCase, ObtenerRolUseCase obtenerRolUseCase) {
        this.crearRolUseCase = crearRolUseCase;
        this.eliminarRolUseCase = eliminarRolUseCase;
        this.obtenerRolUseCase = obtenerRolUseCase;
    }

    @Override
    public Rol crearRol(Rol rol) {
        return crearRolUseCase.crearRol(rol);
    }

    @Override
    public boolean eliminarRolPorId(Long id) {
        return eliminarRolUseCase.eliminarRolPorId(id);
    }

    @Override
    public boolean eliminarRol(String nombre) {
        return eliminarRolUseCase.eliminarRol(nombre);
    }

    @Override
    public List<Rol> obtenerRoles() {
        return obtenerRolUseCase.obtenerRoles();
    }

    @Override
    public Rol obtenerRolPorId(Long id) {
        return obtenerRolUseCase.obtenerRolPorId(id);
    }

    @Override
    public Rol obtenerRol(String nombre) {
        return obtenerRolUseCase.obtenerRol(nombre);
    }
}
