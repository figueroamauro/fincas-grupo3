package com.example.fincas_grupo3.application.usecases.ciudad;

import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import com.example.fincas_grupo3.domain.ports.in.ciudad.EliminarCiudadUseCase;
import com.example.fincas_grupo3.domain.ports.out.ciudad.CiudadOutPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarCiudadUseCaseImpl implements EliminarCiudadUseCase {

    private final CiudadOutPort ciudadOutPort;

    public EliminarCiudadUseCaseImpl(CiudadOutPort ciudadOutPort) {
        this.ciudadOutPort = ciudadOutPort;
    }

    @Override
    public Boolean eliminarCiudad(Ciudad ciudad) {
        return ciudadOutPort.eliminarCiudad(ciudad);
    }

    @Override
    public Boolean eliminarCiudadPorId(Long id) {
        return ciudadOutPort.eliminarCiudadPorId(id);
    }
}
