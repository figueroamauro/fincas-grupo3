package com.example.fincas_grupo3.application.usecases.publicacion;

import com.example.fincas_grupo3.domain.models.publicacion.Publicacion;
import com.example.fincas_grupo3.domain.ports.in.publicacion.CrearPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.out.publicacion.PublicacionOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearPublicacionUseCaseImpl implements CrearPublicacionUseCase {
    private final PublicacionOutPort publicacionOutPort;

    public CrearPublicacionUseCaseImpl(PublicacionOutPort publicacionOutPort) {
        this.publicacionOutPort = publicacionOutPort;
    }

    @Override
    public Publicacion crearPublicacion(Publicacion publicacion) {
        return publicacionOutPort.guardar(publicacion);
    }
}
