package com.example.fincas_grupo3.application.usecases.publicacion;

import com.example.fincas_grupo3.domain.models.publicacion.Publicacion;
import com.example.fincas_grupo3.domain.ports.in.publicacion.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionUseCases implements PublicacionInPort {

    private final CrearPublicacionUseCase crearPublicacionUseCase;
    private final ActualizarPublicacionUseCase actualizarPublicacionUseCase;
    private final EliminarPublicacionUseCase eliminarPublicacionUseCase;
    private final ObtenerPublicacionUseCase obtenerPublicacionUseCase;

    public PublicacionUseCases(
            CrearPublicacionUseCase crearPublicacionUseCase,
            ActualizarPublicacionUseCase actualizarPublicacionUseCase,
            EliminarPublicacionUseCase eliminarPublicacionUseCase,
            ObtenerPublicacionUseCase obtenerPublicacionUseCase
    ) {
        this.crearPublicacionUseCase = crearPublicacionUseCase;
        this.actualizarPublicacionUseCase = actualizarPublicacionUseCase;
        this.eliminarPublicacionUseCase = eliminarPublicacionUseCase;
        this.obtenerPublicacionUseCase = obtenerPublicacionUseCase;
    }

    @Override
    public Publicacion actualizarPublicacion(Publicacion publicacion) {
        return actualizarPublicacionUseCase.actualizarPublicacion(publicacion);
    }

    @Override
    public Publicacion crearPublicacion(Publicacion publicacion) {
        return crearPublicacionUseCase.crearPublicacion(publicacion);
    }

    @Override
    public Boolean eliminarPublicacionPorId(Long id) {
        return eliminarPublicacionUseCase.eliminarPublicacionPorId(id);
    }

    @Override
    public Publicacion obtenerPublicacionPorId(Long id) {
        return obtenerPublicacionUseCase.obtenerPublicacionPorId(id);
    }

    @Override
    public List<Publicacion> obtenerPublicaciones() {
        return obtenerPublicacionUseCase.obtenerPublicaciones();
    }
}
