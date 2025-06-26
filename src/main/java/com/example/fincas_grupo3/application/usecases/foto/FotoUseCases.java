package com.example.fincas_grupo3.application.usecases.foto;

import com.example.fincas_grupo3.domain.models.foto.Foto;
import com.example.fincas_grupo3.domain.ports.in.foto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotoUseCases implements FotoInPort {
    private final CrearFotoUseCase crearFotoUseCase;
    private final ActualizarFotoUseCase actualizarFotoUseCase;
    private final ObtenerFotoUseCase obtenerFotoUseCase;
    private final EliminarFotoUseCase eliminarFotoUseCase;

    public FotoUseCases(CrearFotoUseCase crearFotoUseCase, ActualizarFotoUseCase actualizarFotoUseCase, ObtenerFotoUseCase obtenerFotoUseCase, EliminarFotoUseCase eliminarFotoUseCase) {
        this.crearFotoUseCase = crearFotoUseCase;
        this.actualizarFotoUseCase = actualizarFotoUseCase;
        this.obtenerFotoUseCase = obtenerFotoUseCase;
        this.eliminarFotoUseCase = eliminarFotoUseCase;
    }

    @Override
    public Foto actualizarFoto(Foto foto) {
        return actualizarFotoUseCase.actualizarFoto(foto);
    }

    @Override
    public Foto crearFoto(Foto foto) {
        return crearFotoUseCase.crearFoto(foto);
    }

    @Override
    public Boolean eliminarFotoPorId(Long id) {
        return eliminarFotoUseCase.eliminarFotoPorId(id);
    }

    @Override
    public List<Foto> obtenerFotos() {
        return obtenerFotoUseCase.obtenerFotos();
    }

    @Override
    public Foto obtenerFotoPorId(Long id) {
        return obtenerFotoUseCase.obtenerFotoPorId(id);
    }
}
