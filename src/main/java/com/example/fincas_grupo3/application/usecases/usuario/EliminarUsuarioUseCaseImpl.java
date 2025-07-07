package com.example.fincas_grupo3.application.usecases.usuario;

import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import com.example.fincas_grupo3.domain.ports.in.usuario.EliminarUsuarioUseCase;
import com.example.fincas_grupo3.domain.ports.out.usuario.UsuarioOutPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarUsuarioUseCaseImpl implements EliminarUsuarioUseCase {
private final UsuarioOutPort usuarioOutPort;

    public EliminarUsuarioUseCaseImpl(UsuarioOutPort usuarioOutPort) {
        this.usuarioOutPort = usuarioOutPort;
    }

    @Override
    public Boolean eliminarUsuario(Usuario usuario) {
        return usuarioOutPort.eliminarUsuario(usuario) ;
    }

    @Override
    public Boolean eliminarUsuarioPorId(Long id) {
        return usuarioOutPort.eliminarUsuarioPorId(id);
    }
}
