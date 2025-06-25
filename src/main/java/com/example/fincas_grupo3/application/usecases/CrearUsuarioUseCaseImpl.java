package com.example.fincas_grupo3.application.usecases;

import com.example.fincas_grupo3.domain.models.Usuario;
import com.example.fincas_grupo3.domain.ports.in.CrearUsuarioUseCase;
import com.example.fincas_grupo3.domain.ports.out.UsuarioOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearUsuarioUseCaseImpl implements CrearUsuarioUseCase {
private final UsuarioOutPort usuarioOutPort;

    public CrearUsuarioUseCaseImpl(UsuarioOutPort usuarioOutPort) {
        this.usuarioOutPort = usuarioOutPort;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioOutPort.crearUsuario(usuario);


        }
    }

