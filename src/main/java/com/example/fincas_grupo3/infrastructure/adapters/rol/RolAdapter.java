package com.example.fincas_grupo3.infrastructure.adapters.rol;

import com.example.fincas_grupo3.domain.models.rol.Rol;
import com.example.fincas_grupo3.domain.ports.out.rol.RolOutPort;
import com.example.fincas_grupo3.infrastructure.Mappers.rol.RolMapper;
import com.example.fincas_grupo3.infrastructure.entities.rol.RolEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.rol.JPARolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RolAdapter implements RolOutPort {
    private final JPARolRepository jpaRolRepository;
    private final RolMapper rolMapper;
    public RolAdapter(JPARolRepository jpaRolRepository, RolMapper rolMapper) {
        this.jpaRolRepository = jpaRolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public Rol obtenerRolPorId(Long id) {
        Optional<RolEntidad> rolEncontrado = jpaRolRepository.findById(id);
        if (rolEncontrado.isPresent()) {
            return rolMapper.toModel(rolEncontrado.get());
        }
        return null;
    }

    @Override
    public boolean eliminarRolPorId(Long id) {
        Optional<RolEntidad> rolEncontrado = jpaRolRepository.findById(id);
        if (rolEncontrado.isPresent()) {
            jpaRolRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Rol obtenerRol(String nombre) {
        return jpaRolRepository.findAll().stream().filter(rolEntidad -> rolEntidad.getNombre().equals(nombre)).map(rolMapper::toModel).findFirst().orElse(null);
    }

    @Override
    public List<Rol> obtenerRoles() {
        return List.copyOf(jpaRolRepository.findAll().stream().map(rolMapper::toModel).toList());
    }

    @Override
    public Rol crearRol(Rol rol) {
        RolEntidad entidad = rolMapper.toEntity(rol);
        RolEntidad entidadGuardada = jpaRolRepository.save(entidad);
        return rolMapper.toModel(entidadGuardada);
    }

    @Override
    public boolean eliminarRol(String nombre) {
        Optional<RolEntidad> rolEncontrado = jpaRolRepository.findAll().stream().filter(rolEntidad -> rolEntidad.getNombre().equals(nombre)).findFirst();
        if (rolEncontrado.isPresent()) {
            jpaRolRepository.delete(rolEncontrado.get());
            return true;
        }
        return false;
    }
}
