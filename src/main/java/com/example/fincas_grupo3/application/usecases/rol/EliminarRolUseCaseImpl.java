package com.example.fincas_grupo3.application.usecases.rol;

import com.example.fincas_grupo3.domain.ports.in.rol.EliminarRolUseCase;
import com.example.fincas_grupo3.domain.ports.out.rol.RolOutPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarRolUseCaseImpl implements EliminarRolUseCase {
    private final RolOutPort rolOutPort;

    public EliminarRolUseCaseImpl(RolOutPort rolOutPort) {
        this.rolOutPort = rolOutPort;
    }

    @Override
    public boolean eliminarRolPorId(Long id) {
        return rolOutPort.eliminarRolPorId(id);
    }

    @Override
    public boolean eliminarRol(String nombre) {
        return rolOutPort.eliminarRol(nombre);
    }
}
