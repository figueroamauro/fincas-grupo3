package com.example.fincas_grupo3.application.usecases.foto;

import com.example.fincas_grupo3.domain.models.foto.Foto;
import com.example.fincas_grupo3.domain.ports.in.foto.ActualizarFotoUseCase;
import com.example.fincas_grupo3.domain.ports.out.foto.FotoOutPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarFotoUseCaseImpl implements ActualizarFotoUseCase {
    private final FotoOutPort fotoOutPort;

    public ActualizarFotoUseCaseImpl(FotoOutPort fotoOutPort) {
        this.fotoOutPort = fotoOutPort;
    }

    @Override
    public Foto actualizarFoto(Foto foto) {
        return fotoOutPort.guardar(foto);
    }
}
