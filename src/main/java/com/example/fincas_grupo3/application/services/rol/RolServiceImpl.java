package com.example.fincas_grupo3.application.services.rol;

import com.example.fincas_grupo3.application.dto.rol.RolResponseDTO;
import com.example.fincas_grupo3.application.mappers.rol.RolMapper;
import com.example.fincas_grupo3.application.usecases.rol.RolUseCases;
import com.example.fincas_grupo3.domain.models.rol.Rol;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {
    private final RolUseCases rolUseCases;
    private final RolMapper rolMapper;

    public RolServiceImpl(RolUseCases rolUseCases, RolMapper rolMapper) {
        this.rolUseCases = rolUseCases;
        this.rolMapper = rolMapper;
    }

    @Override
    public RolResponseDTO obtenerPorId(Long id) {
        Rol rol = rolUseCases.obtenerRolPorId(id);
        return rolMapper.toDTO(rol);

    }


    @Override
    public RolResponseDTO guardar(RolResponseDTO rolResponseDTO) {
        Rol model = rolMapper.toModel(rolResponseDTO);
        Rol rol = rolUseCases.crearRol(model);
        return rolMapper.toDTO(rol);
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        if(rolUseCases.obtenerRolPorId(id) == null) {
            return false;
        }
        return rolUseCases.eliminarRolPorId(id);
    }

    @Override
    public List<RolResponseDTO> obtenerRoles() {
        return rolUseCases.obtenerRoles().stream().map(rolMapper::toDTO).collect(Collectors.toList());
    }


}
