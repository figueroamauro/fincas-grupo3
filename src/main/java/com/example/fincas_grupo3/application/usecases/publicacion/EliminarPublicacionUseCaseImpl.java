package com.example.fincas_grupo3.application.usecases.publicacion;

import com.example.fincas_grupo3.domain.ports.in.publicacion.EliminarPublicacionUseCase;
import com.example.fincas_grupo3.domain.ports.out.publicacion.PublicacionOutPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarPublicacionUseCaseImpl implements EliminarPublicacionUseCase {
    private final PublicacionOutPort publicacionOutPort;

    public EliminarPublicacionUseCaseImpl(PublicacionOutPort publicacionOutPort) {
        this.publicacionOutPort = publicacionOutPort;
    }

    @Override
    public Boolean eliminarPublicacionPorId(Long id) {
        return publicacionOutPort.eliminarPorId(id);
    }
}
