package com.example.fincas_grupo3.application.services.usuario;

import com.example.fincas_grupo3.application.dto.usuario.UsuarioRequestDTO;
import com.example.fincas_grupo3.application.dto.usuario.UsuarioResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService  {

    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO usuario);

    UsuarioResponseDTO actualizarUsuario(UsuarioRequestDTO usuario);

    List<UsuarioResponseDTO> obtenerUsuarios();

    UsuarioResponseDTO obtenerUsuarioPorId(Long id);

    Boolean eliminarUsuario(UsuarioRequestDTO usuario);

    Boolean eliminarUsuarioPorId(Long id);

}
