package com.example.fincas_grupo3.application.usecases.provincia;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;
import com.example.fincas_grupo3.domain.ports.in.provincia.ObtenerProvinciaUseCase;
import com.example.fincas_grupo3.domain.ports.out.provincia.ProvinciaOutPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerProvinciaUseCaseImpl implements ObtenerProvinciaUseCase {
    private final ProvinciaOutPort provinciaOutPort;

    public ObtenerProvinciaUseCaseImpl(ProvinciaOutPort provinciaOutPort) {
        this.provinciaOutPort = provinciaOutPort;
    }

    @Override
    public Provincia obtenerProvinciaPorId(Long id) {
        return provinciaOutPort.obtenerPorId(id);
    }

    @Override
    public List<Provincia> obtenerProvincias() {
        return provinciaOutPort.obtenerTodas();
    }
}
