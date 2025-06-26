package com.example.fincas_grupo3.application.usecases.provincia;

import com.example.fincas_grupo3.domain.ports.in.provincia.EliminarProvinciaUseCase;
import com.example.fincas_grupo3.domain.ports.out.provincia.ProvinciaOutPort;

public class EliminarProvinciaUseCaseImpl implements EliminarProvinciaUseCase {
    private final ProvinciaOutPort provinciaOutPort;

    public EliminarProvinciaUseCaseImpl(ProvinciaOutPort provinciaOutPort) {
        this.provinciaOutPort = provinciaOutPort;
    }

    @Override
    public Boolean eliminarProvinciaPorId(Long id) {
        return provinciaOutPort.eliminarPorId(id);
    }
}
