package com.example.fincas_grupo3.application.mappers;

import com.example.fincas_grupo3.application.dto.UsuarioRequestDTO;
import com.example.fincas_grupo3.application.dto.UsuarioResponseDTO;
import com.example.fincas_grupo3.domain.models.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper {

    public static Usuario toModel(UsuarioRequestDTO dto) {

        return new Usuario(dto.getId(), dto.getNombre(), dto.getApellido(), dto.getCorreo(), dto.getContraseña(), dto.getTelefono());
    }

    public static UsuarioResponseDTO toDTO (Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getTelefono());
    }

}
