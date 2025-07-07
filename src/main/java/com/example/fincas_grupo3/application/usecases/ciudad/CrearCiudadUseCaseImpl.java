package com.example.fincas_grupo3.application.usecases.ciudad;

import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import com.example.fincas_grupo3.domain.ports.in.ciudad.CrearCiudadUseCase;
import com.example.fincas_grupo3.domain.ports.out.ciudad.CiudadOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearCiudadUseCaseImpl implements CrearCiudadUseCase {

    private final CiudadOutPort ciudadOutPort;

    public CrearCiudadUseCaseImpl(CiudadOutPort ciudadOutPort) {
        this.ciudadOutPort = ciudadOutPort;
    }

    @Override
    public Ciudad crearCiudadUseCase(Ciudad ciudad) {
        return ciudadOutPort.crearCiudad(ciudad);
    }
}
