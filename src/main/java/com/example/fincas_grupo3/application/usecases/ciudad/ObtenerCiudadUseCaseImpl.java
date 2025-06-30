package com.example.fincas_grupo3.application.usecases.ciudad;

import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import com.example.fincas_grupo3.domain.ports.in.ciudad.ObtenerCiudadUseCase;
import com.example.fincas_grupo3.domain.ports.out.ciudad.CiudadOutPort;
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
