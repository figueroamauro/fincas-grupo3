package com.example.fincas_grupo3.application.services.usuario;

import com.example.fincas_grupo3.application.dto.usuario.UsuarioRequestDTO;
import com.example.fincas_grupo3.application.dto.usuario.UsuarioResponseDTO;
import com.example.fincas_grupo3.application.exceptions.UsuarioNoEncontradoException;
import com.example.fincas_grupo3.application.mappers.usuario.UsuarioMapper;
import com.example.fincas_grupo3.application.usecases.usuario.UsuarioUseCases;
import com.example.fincas_grupo3.domain.models.rol.Rol;
import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioUseCases usuarioUseCases;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioUseCases usuarioUseCases, UsuarioMapper usuarioMapper) {
        this.usuarioUseCases = usuarioUseCases;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO requestDTO) {
        Usuario usuarioModel = usuarioMapper.toModel(requestDTO);
        usuarioModel.setRoles(new HashSet<>());
        usuarioModel.getRoles().add(new Rol("CLIENTE", null));
        Usuario usuarioGuardado = usuarioUseCases.crearUsuario(usuarioModel);
        return usuarioMapper.toDTO(usuarioGuardado);
    }

    @Override
    public UsuarioResponseDTO actualizarUsuario(UsuarioRequestDTO requestDTO) {
        Usuario usuarioActual = usuarioUseCases.obtenerUsuarioPorId(requestDTO.getId());
        if (usuarioActual == null) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado");
        }

        Usuario usuarioParaActualizar = usuarioMapper.toModel(requestDTO);
        usuarioParaActualizar.setId(usuarioActual.getId());

        Usuario usuarioActualizado = usuarioUseCases.actualizarUsuario(usuarioParaActualizar);

        return usuarioMapper.toDTO(usuarioActualizado);
    }

    @Override
    public List<UsuarioResponseDTO> obtenerUsuarios() {
        List<Usuario> listaUsuarios = usuarioUseCases.obtenerUsuarios();
        return listaUsuarios.stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioUseCases.obtenerUsuarioPorId(id);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado");
        }
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public Boolean eliminarUsuario(UsuarioRequestDTO requestDTO) {
        Usuario model = usuarioMapper.toModel(requestDTO);
        return usuarioUseCases.eliminarUsuario(model);
    }

    @Override
    public Boolean eliminarUsuarioPorId(Long id) {
        Usuario usuario = usuarioUseCases.obtenerUsuarioPorId(id);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado");
        }
        return usuarioUseCases.eliminarUsuarioPorId(id);
    }
}