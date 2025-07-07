package com.example.fincas_grupo3.application.usecases.foto;

import com.example.fincas_grupo3.domain.models.foto.Foto;
import com.example.fincas_grupo3.domain.ports.in.foto.CrearFotoUseCase;
import com.example.fincas_grupo3.domain.ports.out.foto.FotoOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearFotoUseCaseImpl implements CrearFotoUseCase {
    private final FotoOutPort fotoOutPort;

    public CrearFotoUseCaseImpl(FotoOutPort fotoOutPort) {
        this.fotoOutPort = fotoOutPort;
    }

    @Override
    public Foto crearFoto(Foto foto) {
        return fotoOutPort.guardar(foto);
    }
}
