package com.example.fincas_grupo3.application.usecases.foto;

import com.example.fincas_grupo3.domain.ports.in.foto.EliminarFotoUseCase;
import com.example.fincas_grupo3.domain.ports.out.foto.FotoOutPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarFotoUseCaseImpl implements EliminarFotoUseCase {
    private final FotoOutPort fotoOutPort;

    public EliminarFotoUseCaseImpl(FotoOutPort fotoOutPort) {
        this.fotoOutPort = fotoOutPort;
    }

    @Override
    public Boolean eliminarFotoPorId(Long id) {
        return fotoOutPort.eliminarPorId(id);
    }
}
