package com.example.fincas_grupo3.ciudades.application.usecases;

import com.example.fincas_grupo3.ciudades.domain.models.Ciudad;
import com.example.fincas_grupo3.ciudades.domain.ports.in.ObtenerCiudadUseCase;
import com.example.fincas_grupo3.ciudades.domain.ports.out.CiudadOutPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerCiudadUseCaseImpl implements ObtenerCiudadUseCase {

    private final CiudadOutPort ciudadOutPort;

    public ObtenerCiudadUseCaseImpl(CiudadOutPort ciudadOutPort) {
        this.ciudadOutPort = ciudadOutPort;
    }

    @Override
    public List<Ciudad> obtenerCiudades() {
        return ciudadOutPort.obtenerCiudad();
    }

    @Override
    public Ciudad obtenerCiudadPorId(Long id) {
        return ciudadOutPort.obtenerCiudadPorId(id);
    }
}
