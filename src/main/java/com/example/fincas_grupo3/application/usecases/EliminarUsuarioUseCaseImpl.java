package com.example.fincas_grupo3.application.usecases;

import com.example.fincas_grupo3.domain.models.Usuario;
import com.example.fincas_grupo3.domain.ports.in.EliminarUsuarioUseCase;
import com.example.fincas_grupo3.domain.ports.out.UsuarioOutPort;
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
