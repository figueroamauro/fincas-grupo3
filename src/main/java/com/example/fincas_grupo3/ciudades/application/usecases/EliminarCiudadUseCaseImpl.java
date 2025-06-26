package com.example.fincas_grupo3.ciudades.application.usecases;

import com.example.fincas_grupo3.ciudades.domain.models.Ciudad;
import com.example.fincas_grupo3.ciudades.domain.ports.in.EliminarCiudadUseCase;
import com.example.fincas_grupo3.ciudades.domain.ports.out.CiudadOutPort;
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
