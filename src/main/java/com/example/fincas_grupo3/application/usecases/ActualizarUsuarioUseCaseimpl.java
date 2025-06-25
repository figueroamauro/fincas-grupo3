package com.example.fincas_grupo3.application.usecases;

import com.example.fincas_grupo3.domain.models.Usuario;
import com.example.fincas_grupo3.domain.ports.in.ActualizarUsuarioUseCase;
import com.example.fincas_grupo3.domain.ports.out.UsuarioOutPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarUsuarioUseCaseimpl implements ActualizarUsuarioUseCase {
    private final UsuarioOutPort usuarioOutPort;

    public ActualizarUsuarioUseCaseimpl(UsuarioOutPort usuarioOutPort) {
        this.usuarioOutPort = usuarioOutPort;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioOutPort.actualizarUsuario( usuario);
    }
}
