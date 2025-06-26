package com.example.fincas_grupo3.application.usecases.servicio;

import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import com.example.fincas_grupo3.domain.ports.in.servicio.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiciosUseCases implements ServicioInPort {

    private final ActualizarServicioUseCase actualizarServicioUseCaseImpl;
    private final CrearServicioUseCase crearServicioUseCaseImpl;
    private final EliminarServicioUseCase eliminarServicioUseCaseImpl;
    private final ObtenerServicioUseCase obtenerServicioUseCaseImpl;

    public ServiciosUseCases(ActualizarServicioUseCase actualizarServicioUseCaseImpl, CrearServicioUseCase crearServicioUseCaseImpl, EliminarServicioUseCase eliminarServicioUseCaseImpl, ObtenerServicioUseCase obtenerServicioUseCaseImpl) {
        this.actualizarServicioUseCaseImpl = actualizarServicioUseCaseImpl;
        this.crearServicioUseCaseImpl = crearServicioUseCaseImpl;
        this.eliminarServicioUseCaseImpl = eliminarServicioUseCaseImpl;
        this.obtenerServicioUseCaseImpl = obtenerServicioUseCaseImpl;
    }


    @Override
    public Servicio actualizarServicio(Servicio direccion) {
        return  actualizarServicioUseCaseImpl.actualizarServicio(direccion);
    }

    @Override
    public Servicio crearServicio(Servicio servicio) {
        return  crearServicioUseCaseImpl.crearServicio(servicio);
    }

    @Override
    public Boolean eliminarServicioPorId(Long id) {
        return  eliminarServicioUseCaseImpl.eliminarServicioPorId(id);
    }

    @Override
    public List<Servicio> obtenerServicios() {
        return  obtenerServicioUseCaseImpl.obtenerServicios();
    }

    @Override
    public Servicio obtenerServicioPorId(Long id) {
        return  obtenerServicioUseCaseImpl.obtenerServicioPorId(id);
    }
}
