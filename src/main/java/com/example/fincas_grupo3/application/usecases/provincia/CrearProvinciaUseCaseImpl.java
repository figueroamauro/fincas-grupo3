package com.example.fincas_grupo3.application.usecases.provincia;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;
import com.example.fincas_grupo3.domain.ports.in.provincia.CrearProvinciaUseCase;
import com.example.fincas_grupo3.domain.ports.out.provincia.ProvinciaOutPort;

public class CrearProvinciaUseCaseImpl implements CrearProvinciaUseCase {
    private final ProvinciaOutPort provinciaOutPort;

    public CrearProvinciaUseCaseImpl(ProvinciaOutPort provinciaOutPort) {
        this.provinciaOutPort = provinciaOutPort;
    }

    @Override
    public Provincia crearProvincia(Provincia provincia) {
        return provinciaOutPort.guardar(provincia);
    }
}
