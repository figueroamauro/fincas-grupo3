package com.example.fincas_grupo3.application.usecases.publicacion;

import com.example.fincas_grupo3.domain.models.publicacion.Publicacion;
import com.example.fincas_grupo3.domain.ports.in.publicacion.ActualizarPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.out.publicacion.PublicacionOutPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarPublicacionUseCaseImpl implements ActualizarPublicacionUseCase {
    private final PublicacionOutPort publicacionOutPort;

    public ActualizarPublicacionUseCaseImpl(PublicacionOutPort publicacionOutPort) {
        this.publicacionOutPort = publicacionOutPort;
    }

    @Override
    public Publicacion actualizarPublicacion(Publicacion publicacion) {
        return publicacionOutPort.actualizar(publicacion);
    }
}
