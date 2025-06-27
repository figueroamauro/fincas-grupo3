package com.example.fincas_grupo3.application.usecases.publicacion;

import com.example.fincas_grupo3.domain.models.publicacion.Publicacion;
import com.example.fincas_grupo3.domain.ports.in.publicacion.ObtenerPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.out.publicacion.PublicacionOutPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerPublicacionUseCaseImpl implements ObtenerPublicacionUseCase {
    private final PublicacionOutPort publicacionOutPort;

    public ObtenerPublicacionUseCaseImpl(PublicacionOutPort publicacionOutPort) {
        this.publicacionOutPort = publicacionOutPort;
    }

    @Override
    public Publicacion obtenerPublicacionPorId(Long id) {
        return publicacionOutPort.obtenerPorId(id);
    }

    @Override
    public List<Publicacion> obtenerPublicaciones() {
        return publicacionOutPort.obtenerTodas();
    }
}
