package com.example.fincas_grupo3.application.mappers.usuario;

import com.example.fincas_grupo3.application.dto.usuario.UsuarioRequestDTO;
import com.example.fincas_grupo3.application.dto.usuario.UsuarioResponseDTO;
import com.example.fincas_grupo3.application.exceptions.DireccionNoEncontradaException;
import com.example.fincas_grupo3.application.exceptions.RolNoEncontradoException;
import com.example.fincas_grupo3.application.mappers.direccion.DireccionMapper;
import com.example.fincas_grupo3.application.mappers.rol.RolMapper;
import com.example.fincas_grupo3.application.usecases.direccion.DireccionUseCases;
import com.example.fincas_grupo3.application.usecases.rol.RolUseCases;
import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.domain.models.rol.Rol;
import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = {DireccionMapper.class, RolMapper.class},
        implementationName = "usuarioMapperApplicationImpl")
public abstract class UsuarioMapper {

    @Autowired
    protected DireccionUseCases direccionUseCases;
    @Autowired
    protected RolUseCases rolUseCases;

    @Mapping(source = "direccionId", target = "direccion", qualifiedByName = "mapDireccionIdToDireccion")
    @Mapping(source = "rolIds", target = "roles", qualifiedByName = "mapRolIdsToRoles")
    public abstract Usuario toModel(UsuarioRequestDTO dto);


    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "roles", target = "roles")
    public abstract UsuarioResponseDTO toDTO(Usuario usuario);

    @Named("mapDireccionIdToDireccion")
    protected Direccion mapDireccionIdToDireccion(Long direccionId) {
        if (direccionId == null) {
            return null;
        }
        Direccion direccion = direccionUseCases.obtenerDireccionPorId(direccionId);
        if (direccion == null) {
            throw new DireccionNoEncontradaException("Dirección con id " + direccionId + " no encontrada.");
        }
        return direccion;
    }

    @Named("mapRolIdsToRoles")
    protected Set<Rol> mapRolIdsToRoles(List<Long> rolIds) {
        if (rolIds == null || rolIds.isEmpty()) {
            return Collections.emptySet();
        }
        return rolIds.stream()
                .map(rolId -> {
                    Rol rol = rolUseCases.obtenerRolPorId(rolId);
                    if (rol == null) {
                        throw new RolNoEncontradoException("Rol con id " + rolId + " no encontrado.");
                    }
                    return rol;
                })
                .collect(Collectors.toSet());
    }
}