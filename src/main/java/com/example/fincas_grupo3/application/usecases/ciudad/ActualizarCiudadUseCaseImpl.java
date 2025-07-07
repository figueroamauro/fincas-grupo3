package com.example.fincas_grupo3.application.usecases.ciudad;


import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import com.example.fincas_grupo3.domain.ports.in.ciudad.ActualizarCiudadUseCase;
import com.example.fincas_grupo3.domain.ports.out.ciudad.CiudadOutPort;
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
