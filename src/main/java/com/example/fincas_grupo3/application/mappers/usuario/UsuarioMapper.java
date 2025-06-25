package com.example.fincas_grupo3.application.mappers.usuario;

import com.example.fincas_grupo3.application.dto.usuario.UsuarioRequestDTO;
import com.example.fincas_grupo3.application.dto.usuario.UsuarioResponseDTO;
import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring", implementationName = "usuarioMapperApplication")
public class UsuarioMapper {

    public static Usuario toModel(UsuarioRequestDTO dto) {

        return new Usuario(dto.getId(), dto.getNombre(), dto.getApellido(), dto.getCorreo(), dto.getContraseña(), dto.getTelefono());
    }

    public static UsuarioResponseDTO toDTO (Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getTelefono());
    }

}
