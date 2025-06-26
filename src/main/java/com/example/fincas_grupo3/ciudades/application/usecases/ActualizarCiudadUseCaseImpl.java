package com.example.fincas_grupo3.ciudades.application.usecases;


import com.example.fincas_grupo3.ciudades.domain.models.Ciudad;
import com.example.fincas_grupo3.ciudades.domain.ports.in.ActualizarCiudadUseCase;
import com.example.fincas_grupo3.ciudades.domain.ports.out.CiudadOutPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarCiudadUseCaseImpl implements ActualizarCiudadUseCase {

    private final CiudadOutPort ciudadOutPort;

    public ActualizarCiudadUseCaseImpl(CiudadOutPort ciudadOutPort) {
        this.ciudadOutPort = ciudadOutPort;
    }

    @Override
    public Ciudad actualizarCiudadUseCase(Ciudad ciudad) {
        return ciudadOutPort.actualizarCiudad(ciudad);
    }
}
