package com.example.fincas_grupo3.application.usecases.servicio;

import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import com.example.fincas_grupo3.domain.ports.in.servicio.ObtenerServicioUseCase;
import com.example.fincas_grupo3.domain.ports.out.servicio.ServicioOutPort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ObtenerServicioUseCaseImpl implements ObtenerServicioUseCase {
    private final ServicioOutPort servicioOutPort;

    public ObtenerServicioUseCaseImpl(ServicioOutPort servicioOutPort) {
        this.servicioOutPort = servicioOutPort;
    }

    @Override
    public List<Servicio> obtenerServicios() {
        return servicioOutPort.obtenerTodas();
    }

    @Override
    public Servicio obtenerServicioPorId(Long id) {
        return servicioOutPort.obtenerServicioPorId(id);
    }
}
