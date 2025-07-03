package com.example.fincas_grupo3.infrastructure.mappers.usuario;

import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import com.example.fincas_grupo3.infrastructure.entities.usuario.UsuarioEntidad;
import com.example.fincas_grupo3.infrastructure.mappers.rol.RolMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", implementationName = "usuarioMapperInfra", uses = {RolMapper.class})
public abstract class UsuarioMapper {

    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "roles", target = "roles")
    public abstract UsuarioEntidad toEntity(Usuario usuario);


    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "roles", target = "roles")
    public abstract Usuario toModel(UsuarioEntidad entidad);
}