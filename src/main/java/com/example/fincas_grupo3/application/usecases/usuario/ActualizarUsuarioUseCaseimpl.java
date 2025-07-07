package com.example.fincas_grupo3.application.usecases.usuario;

import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import com.example.fincas_grupo3.domain.ports.in.usuario.ActualizarUsuarioUseCase;
import com.example.fincas_grupo3.domain.ports.out.usuario.UsuarioOutPort;
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
