package com.example.fincas_grupo3.infrastructure.adapters.usuario;

import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import com.example.fincas_grupo3.domain.ports.out.usuario.UsuarioOutPort;
import com.example.fincas_grupo3.infrastructure.mappers.usuario.UsuarioMapper;
import com.example.fincas_grupo3.infrastructure.entities.usuario.UsuarioEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.usuario.JPAUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioAdapter implements UsuarioOutPort {
    private final JPAUsuarioRepository jpaUsuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioAdapter(JPAUsuarioRepository jpaUsuarioRepository, UsuarioMapper usuarioMapper) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        UsuarioEntidad entidad = usuarioMapper.toEntity(usuario);

        UsuarioEntidad entidadGuardada = jpaUsuarioRepository.save(entidad);

        return usuarioMapper.toModel(entidadGuardada);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        UsuarioEntidad entidad = usuarioMapper.toEntity(usuario);

        UsuarioEntidad entidadGuardada = jpaUsuarioRepository.save(entidad);

        return usuarioMapper.toModel(entidadGuardada);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return jpaUsuarioRepository.findAll().stream().map(usuarioMapper::toModel).toList();

    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        Optional<UsuarioEntidad> usuarioGuardado = jpaUsuarioRepository.findById(id);
        if (usuarioGuardado.isPresent()) {
           return usuarioMapper.toModel(usuarioGuardado.get());

        }
        return null;
    }

    @Override
    public Boolean eliminarUsuario(Usuario usuario) {
        Optional<UsuarioEntidad> usuarioEncontrado = jpaUsuarioRepository.findById(usuario.getId());
        if (usuarioEncontrado.isPresent()) {
            jpaUsuarioRepository.delete(usuarioEncontrado.get());
            return true;
        }
        return false;
    }

    @Override
    public Boolean eliminarUsuarioPorId(Long id) {
        Optional<UsuarioEntidad> usuarioEncontrado = jpaUsuarioRepository.findById(id);
        if (usuarioEncontrado.isPresent()) {
            jpaUsuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
