package com.example.fincas_grupo3.application.usecases.direccion;

import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.domain.ports.in.direccion.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DireccionUseCases implements DireccionInPort {
    private final CrearDireccionUseCase crearDireccionUseCase;
    private final ActualizarDireccionUseCase actualizarDireccionUseCase;
    private final EliminarDireccionUseCase eliminarDireccionUseCase;
    private final ObtenerDireccionUseCase obtenerDireccionUseCase;

    public DireccionUseCases(CrearDireccionUseCase crearDireccionUseCase, ActualizarDireccionUseCase actualizarDireccionUseCase, EliminarDireccionUseCase eliminarDireccionUseCase, ObtenerDireccionUseCase obtenerDireccionUseCase) {
        this.crearDireccionUseCase = crearDireccionUseCase;
        this.actualizarDireccionUseCase = actualizarDireccionUseCase;
        this.eliminarDireccionUseCase = eliminarDireccionUseCase;
        this.obtenerDireccionUseCase = obtenerDireccionUseCase;
    }


    @Override
    public Direccion actualizarDireccion(Direccion direccion) {
        return actualizarDireccionUseCase.actualizarDireccion(direccion);
    }

    @Override
    public Direccion crearDireccion(Direccion direccion) {
        return crearDireccionUseCase.crearDireccion(direccion);
    }

    @Override
    public Boolean eliminarDireccionPorId(Long id) {
        return eliminarDireccionUseCase.eliminarDireccionPorId(id);
    }

    @Override
    public List<Direccion> obtenerDirecciones() {
        return obtenerDireccionUseCase.obtenerDirecciones();
    }

    @Override
    public Direccion obtenerDireccionPorId(Long id) {
        return obtenerDireccionUseCase.obtenerDireccionPorId(id);
    }
}

