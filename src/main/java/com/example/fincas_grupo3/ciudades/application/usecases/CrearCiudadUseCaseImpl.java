package com.example.fincas_grupo3.ciudades.application.usecases;

import com.example.fincas_grupo3.ciudades.domain.models.Ciudad;
import com.example.fincas_grupo3.ciudades.domain.ports.in.CrearCiudadUseCase;
import com.example.fincas_grupo3.ciudades.domain.ports.out.CiudadOutPort;
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
