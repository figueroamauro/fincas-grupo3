package com.example.fincas_grupo3.application.usecases.foto;

import com.example.fincas_grupo3.domain.models.foto.Foto;
import com.example.fincas_grupo3.domain.ports.in.foto.ObtenerFotoUseCase;
import com.example.fincas_grupo3.domain.ports.out.foto.FotoOutPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerFotoUseCaseImpl implements ObtenerFotoUseCase {
    private final FotoOutPort fotoOutPort;

    public ObtenerFotoUseCaseImpl(FotoOutPort fotoOutPort) {
        this.fotoOutPort = fotoOutPort;
    }

    @Override
    public List<Foto> obtenerFotos() {
        return fotoOutPort.obtenerTodas();
    }

    @Override
    public Foto obtenerFotoPorId(Long id) {
        return fotoOutPort.obtenerPorId(id);
    }
}
