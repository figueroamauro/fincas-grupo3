package com.example.fincas_grupo3.infrastructure.Mappers;


import com.example.fincas_grupo3.domain.models.Usuario;
import com.example.fincas_grupo3.infrastructure.entities.UsuarioEntidad;

public class UsuarioMapper {

    public static UsuarioEntidad toEntity(Usuario usuario ) {

        return new UsuarioEntidad(usuario.getId(), usuario.getNombre(),  usuario.getApellido(),  usuario.getCorreo(), usuario.getContraseña(), usuario.getTelefono());

    }

    public static Usuario toModel (UsuarioEntidad usuarioEntidad ) {
        return new Usuario(usuarioEntidad.getId(),usuarioEntidad.getNombre(), usuarioEntidad.getApellido(), usuarioEntidad.getCorreo(), usuarioEntidad.getContraseña(), usuarioEntidad.getTelefono());
    }

}
