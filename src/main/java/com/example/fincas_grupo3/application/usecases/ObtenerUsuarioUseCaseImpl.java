package com.example.fincas_grupo3.application.usecases;

import com.example.fincas_grupo3.domain.models.Usuario;
import com.example.fincas_grupo3.domain.ports.in.ObtenerUsuarioUseCase;
import com.example.fincas_grupo3.domain.ports.out.UsuarioOutPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerUsuarioUseCaseImpl implements ObtenerUsuarioUseCase {
    private final UsuarioOutPort usuarioOutPort;

    public ObtenerUsuarioUseCaseImpl(UsuarioOutPort usuarioOutPort) {
        this.usuarioOutPort = usuarioOutPort;
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioOutPort.obtenerUsuarios();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioOutPort.obtenerUsuarioPorId(id);
    }
}
