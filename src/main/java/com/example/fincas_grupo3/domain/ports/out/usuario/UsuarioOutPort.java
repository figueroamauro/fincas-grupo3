package com.example.fincas_grupo3.domain.ports.out.usuario;

import com.example.fincas_grupo3.domain.models.usuario.Usuario;

import java.util.List;

public interface UsuarioOutPort {

    Usuario crearUsuario(Usuario usuario);

    Usuario actualizarUsuario(Usuario usuario);

    List<Usuario> obtenerUsuarios();

    Usuario obtenerUsuarioPorId(Long id);

    Usuario obtenerUsuarioPorCorreo(String correo);

    Boolean eliminarUsuario(Usuario usuario);

    Boolean eliminarUsuarioPorId(Long id);

}
