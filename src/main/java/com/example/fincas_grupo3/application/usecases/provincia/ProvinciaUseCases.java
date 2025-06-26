package com.example.fincas_grupo3.application.usecases.provincia;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;
import com.example.fincas_grupo3.domain.ports.in.provincia.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaUseCases implements ProvinciaInPort {

    private final CrearProvinciaUseCase crearProvinciaUseCase;
    private final ActualizarProvinciaUseCase actualizarProvinciaUseCase;
    private final EliminarProvinciaUseCase eliminarProvinciaUseCase;
    private final ObtenerProvinciaUseCase obtenerProvinciaUseCase;

    public ProvinciaUseCases(CrearProvinciaUseCase crearProvinciaUseCase, ActualizarProvinciaUseCase actualizarProvinciaUseCase, EliminarProvinciaUseCase eliminarProvinciaUseCase, ObtenerProvinciaUseCase obtenerProvinciaUseCase) {
        this.crearProvinciaUseCase = crearProvinciaUseCase;
        this.actualizarProvinciaUseCase = actualizarProvinciaUseCase;
        this.eliminarProvinciaUseCase = eliminarProvinciaUseCase;
        this.obtenerProvinciaUseCase = obtenerProvinciaUseCase;
    }

    @Override
    public Provincia actualizarProvincia(Provincia provincia) {
        return actualizarProvinciaUseCase.actualizarProvincia(provincia);
    }

    @Override
    public Provincia crearProvincia(Provincia provincia) {
        return crearProvinciaUseCase.crearProvincia(provincia);
    }

    @Override
    public Boolean eliminarProvinciaPorId(Long id) {
        return eliminarProvinciaUseCase.eliminarProvinciaPorId(id);
    }

    @Override
    public Provincia obtenerProvinciaPorId(Long id) {
        return obtenerProvinciaUseCase.obtenerProvinciaPorId(id);
    }

    @Override
    public List<Provincia> obtenerProvincias() {
        return obtenerProvinciaUseCase.obtenerProvincias();
    }
}
