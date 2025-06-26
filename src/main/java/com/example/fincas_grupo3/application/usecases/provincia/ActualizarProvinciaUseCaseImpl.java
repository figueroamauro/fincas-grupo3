package com.example.fincas_grupo3.application.usecases.provincia;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;
import com.example.fincas_grupo3.domain.ports.in.provincia.ActualizarProvinciaUseCase;
import com.example.fincas_grupo3.domain.ports.out.provincia.ProvinciaOutPort;

public class ActualizarProvinciaUseCaseImpl implements ActualizarProvinciaUseCase {
    private final ProvinciaOutPort provinciaOutPort;

    public ActualizarProvinciaUseCaseImpl(ProvinciaOutPort provinciaOutPort) {
        this.provinciaOutPort = provinciaOutPort;
    }

    @Override
    public Provincia actualizarProvincia(Provincia provincia) {
        return provinciaOutPort.actualizar(provincia);
    }
}
