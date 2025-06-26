package com.example.fincas_grupo3.ciudades.application.usecases;

import com.example.fincas_grupo3.ciudades.domain.models.Ciudad;
import com.example.fincas_grupo3.ciudades.domain.ports.in.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadUseCases implements CiudadInPort {

    private final CrearCiudadUseCase crearCiudadUseCase;
    private final EliminarCiudadUseCase eliminarCiudadUseCase;
    private final ObtenerCiudadUseCase obtenerCiudadUseCase;
    private final ActualizarCiudadUseCase actualizarCiudadUseCase;

    public CiudadUseCases(
            CrearCiudadUseCase crearCiudadUseCase,
            EliminarCiudadUseCase eliminarCiudadUseCase,
            ObtenerCiudadUseCase obtenerCiudadUseCase,
            ActualizarCiudadUseCase actualizarCiudadUseCase
    ) {
        this.crearCiudadUseCase = crearCiudadUseCase;
        this.eliminarCiudadUseCase = eliminarCiudadUseCase;
        this.obtenerCiudadUseCase = obtenerCiudadUseCase;
        this.actualizarCiudadUseCase = actualizarCiudadUseCase;
    }



    @Override
    public Ciudad actualizarCiudadUseCase(Ciudad ciudad) {
        return actualizarCiudadUseCase.actualizarCiudadUseCase(ciudad);
    }

    @Override
    public Ciudad crearCiudadUseCase(Ciudad ciudad) {
        return crearCiudadUseCase.crearCiudadUseCase(ciudad);
    }

    @Override
    public Boolean eliminarCiudad(Ciudad ciudad) {
        return eliminarCiudadUseCase.eliminarCiudad(ciudad);
    }

    @Override
    public Boolean eliminarCiudadPorId(Long id) {
        return eliminarCiudadUseCase.eliminarCiudadPorId(id);
    }

    @Override
    public List<Ciudad> obtenerCiudades() {
        return obtenerCiudadUseCase.obtenerCiudades();
    }

    @Override
    public Ciudad obtenerCiudadPorId(Long id) {
        return obtenerCiudadUseCase.obtenerCiudadPorId(id);
    }
}
