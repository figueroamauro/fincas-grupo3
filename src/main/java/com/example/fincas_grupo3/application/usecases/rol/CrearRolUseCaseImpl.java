package com.example.fincas_grupo3.application.usecases.rol;

import com.example.fincas_grupo3.domain.models.rol.Rol;
import com.example.fincas_grupo3.domain.ports.in.rol.CrearRolUseCase;
import com.example.fincas_grupo3.domain.ports.out.rol.RolOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearRolUseCaseImpl implements CrearRolUseCase {
    private final RolOutPort rolOutPort;

    public CrearRolUseCaseImpl(RolOutPort rolOutPort) {
        this.rolOutPort = rolOutPort;
    }

    @Override
    public Rol crearRol(Rol rol) {
        return rolOutPort.crearRol(rol);
    }
}
