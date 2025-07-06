package com.example.fincas_grupo3.application.usecases.usuario;

import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import com.example.fincas_grupo3.domain.ports.in.usuario.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUseCases  implements UsuarioInPort {
    private final CrearUsuarioUseCase crearUsuarioUseCase;
    private final EliminarUsuarioUseCase eliminarUsuarioUseCase;
    private final ObtenerUsuarioUseCase obtenerUsuarioUseCase ;
    private final ActualizarUsuarioUseCase actualizarUsuarioUseCase;

    public UsuarioUseCases(CrearUsuarioUseCase crearUsuarioUseCase, EliminarUsuarioUseCase eliminarUsuarioUseCase, ObtenerUsuarioUseCase obtenerUsuarioUseCase, ActualizarUsuarioUseCase actualizarUsuarioUseCase) {
        this.crearUsuarioUseCase = crearUsuarioUseCase;
        this.eliminarUsuarioUseCase = eliminarUsuarioUseCase;
        this.obtenerUsuarioUseCase = obtenerUsuarioUseCase;
        this.actualizarUsuarioUseCase = actualizarUsuarioUseCase;
    }


    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return actualizarUsuarioUseCase.actualizarUsuario(usuario);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return crearUsuarioUseCase.crearUsuario(usuario) ;
    }

    @Override
    public Boolean eliminarUsuario(Usuario usuario) {
        return eliminarUsuarioUseCase.eliminarUsuario(usuario);
    }

    @Override
    public Boolean eliminarUsuarioPorId(Long id) {
        return eliminarUsuarioUseCase.eliminarUsuarioPorId(id);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return obtenerUsuarioUseCase.obtenerUsuarios();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return obtenerUsuarioUseCase.obtenerUsuarioPorId(id);
    }

    @Override
    public Usuario obtenerUsuarioPorCorreo(String correo) {
        return obtenerUsuarioUseCase.obtenerUsuarioPorCorreo(correo);
    }
}
