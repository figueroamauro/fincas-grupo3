package com.example.fincas_grupo3.application.usecases.servicio;

import com.example.fincas_grupo3.domain.ports.in.servicio.EliminarServicioUseCase;
import com.example.fincas_grupo3.domain.ports.out.servicio.ServicioOutPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarServicioUseCaseImpl implements EliminarServicioUseCase {
    private final ServicioOutPort servicioOutPort;

    public EliminarServicioUseCaseImpl(ServicioOutPort servicioOutPort) {
        this.servicioOutPort = servicioOutPort;
    }

    @Override
    public Boolean eliminarServicioPorId(Long id) {
        return servicioOutPort.eliminarServicioPorId(id);
    }
}
