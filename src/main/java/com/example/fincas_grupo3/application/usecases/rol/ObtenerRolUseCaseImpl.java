package com.example.fincas_grupo3.application.usecases.rol;

import com.example.fincas_grupo3.domain.models.rol.Rol;
import com.example.fincas_grupo3.domain.ports.in.rol.ObtenerRolUseCase;
import com.example.fincas_grupo3.domain.ports.out.rol.RolOutPort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ObtenerRolUseCaseImpl implements ObtenerRolUseCase {
    private final RolOutPort rolOutPort;

    public ObtenerRolUseCaseImpl(RolOutPort rolOutPort) {
        this.rolOutPort = rolOutPort;
    }

    @Override
    public List<Rol> obtenerRoles() {
        return rolOutPort.obtenerRoles();
    }

    @Override
    public Rol obtenerRolPorId(Long id) {
        return rolOutPort.obtenerRolPorId(id);
    }

    @Override
    public Rol obtenerRol(String nombre) {
        return rolOutPort.obtenerRol(nombre);
    }
}
