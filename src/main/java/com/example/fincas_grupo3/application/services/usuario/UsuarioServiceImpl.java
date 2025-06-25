package com.example.fincas_grupo3.application.services.usuario;
import com.example.fincas_grupo3.application.dto.usuario.UsuarioRequestDTO;
import com.example.fincas_grupo3.application.dto.usuario.UsuarioResponseDTO;
import com.example.fincas_grupo3.application.mappers.usuario.UsuarioMapper;
import com.example.fincas_grupo3.application.usecases.usuario.UsuarioUseCases;
import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioUseCases usuarioUseCases;


    public UsuarioServiceImpl(UsuarioUseCases usuarioUseCases) {
        this.usuarioUseCases = usuarioUseCases;

    }

    @Override
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {
        Usuario model = UsuarioMapper.toModel(dto);
        Usuario usuarioGuardado = usuarioUseCases.crearUsuario(model);
        return UsuarioMapper.toDTO(usuarioGuardado);
    }

    @Override
    public UsuarioResponseDTO actualizarUsuario(UsuarioRequestDTO dto) {
        Usuario usuarioEncontrado = usuarioUseCases.obtenerUsuarioPorId(dto.getId());

        if(usuarioEncontrado==null) throw new IllegalArgumentException("No se encontro el usuario con el id: " + dto.getId());

        usuarioEncontrado.setNombre(dto.getNombre());
        usuarioEncontrado.setApellido(dto.getApellido());
        usuarioEncontrado.setCorreo(dto.getCorreo());
        usuarioEncontrado.setContraseña(dto.getContraseña());
        usuarioEncontrado.setTelefono(dto.getTelefono());


        Usuario usuarioGuardado = usuarioUseCases.actualizarUsuario(usuarioEncontrado);
        return UsuarioMapper.toDTO(usuarioGuardado);

    }

    @Override
    public List<UsuarioResponseDTO> obtenerUsuarios() {
        return usuarioUseCases.obtenerUsuarios().stream().map(u -> UsuarioMapper.toDTO(u)).toList();


    }

    @Override
    public UsuarioResponseDTO obtenerUsuarioPorId(Long id) {
        Usuario usuarioGuardado = usuarioUseCases.obtenerUsuarioPorId(id);
        return UsuarioMapper.toDTO(usuarioGuardado);
    }

    @Override
    public Boolean eliminarUsuario(UsuarioRequestDTO dto) {
        Usuario model = UsuarioMapper.toModel(dto);
      return usuarioUseCases.eliminarUsuario(model);
    }

    @Override
    public Boolean eliminarUsuarioPorId(Long id) {
        Usuario usuarioEncontrado = usuarioUseCases.obtenerUsuarioPorId(id);
        if (usuarioEncontrado != null) {
           return usuarioUseCases.eliminarUsuarioPorId(id);

        }

        return false;
    }
}
