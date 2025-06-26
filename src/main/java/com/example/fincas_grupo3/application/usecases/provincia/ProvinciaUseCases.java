package com.example.fincas_grupo3.application.usecases.provincia;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;
import com.example.fincas_grupo3.domain.ports.in.provincia.ProvinciaInPort;

import java.util.List;

public class ProvinciaUseCases implements ProvinciaInPort {

    private final ProvinciaInPort provinciaInPort;

    public ProvinciaUseCases(ProvinciaInPort provinciaInPort) {
        this.provinciaInPort = provinciaInPort;
    }

    @Override
    public Provincia actualizarProvincia(Provincia provincia) {
        return provinciaInPort.actualizarProvincia(provincia);
    }

    @Override
    public Provincia crearProvincia(Provincia provincia) {
        return provinciaInPort.crearProvincia(provincia);
    }

    @Override
    public Boolean eliminarProvinciaPorId(Long id) {
        return provinciaInPort.eliminarProvinciaPorId(id);
    }

    @Override
    public Provincia obtenerProvinciaPorId(Long id) {
        return provinciaInPort.obtenerProvinciaPorId(id);
    }

    @Override
    public List<Provincia> obtenerProvincias() {
        return provinciaInPort.obtenerProvincias();
    }
}
