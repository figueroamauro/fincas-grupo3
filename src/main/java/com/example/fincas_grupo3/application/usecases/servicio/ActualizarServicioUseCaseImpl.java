package com.example.fincas_grupo3.application.usecases.servicio;

import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import com.example.fincas_grupo3.domain.ports.in.servicio.ActualizarServicioUseCase;
import com.example.fincas_grupo3.domain.ports.out.servicio.ServicioOutPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarServicioUseCaseImpl implements ActualizarServicioUseCase {
    private final ServicioOutPort servicioOutPort;

    public ActualizarServicioUseCaseImpl(ServicioOutPort servicioOutPort) {
        this.servicioOutPort = servicioOutPort;

    }

    @Override
    public Servicio actualizarServicio(Servicio direccion) {
        return servicioOutPort.guardar(direccion);
    }
}
