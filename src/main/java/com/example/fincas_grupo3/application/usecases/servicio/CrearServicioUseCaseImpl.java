package com.example.fincas_grupo3.application.usecases.servicio;

import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import com.example.fincas_grupo3.domain.ports.in.servicio.CrearServicioUseCase;
import com.example.fincas_grupo3.domain.ports.out.servicio.ServicioOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearServicioUseCaseImpl implements CrearServicioUseCase {
    private final ServicioOutPort servicioOutPort;
    public CrearServicioUseCaseImpl(ServicioOutPort servicioOutPort) {
        this.servicioOutPort = servicioOutPort;

    }


    @Override
    public Servicio crearServicio(Servicio servicio) {
        return servicioOutPort.guardar(servicio);
    }
}
