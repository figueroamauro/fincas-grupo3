package com.example.fincas_grupo3.infrastructure.mappers.finca;

import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.infrastructure.entities.finca.FincaEntidad;
import com.example.fincas_grupo3.infrastructure.mappers.direccion.DireccionMapper;
import com.example.fincas_grupo3.infrastructure.mappers.usuario.UsuarioMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DireccionMapper.class, UsuarioMapper.class}, implementationName = "fincaMapperInfra")
public abstract class FincaMapper {

    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "usuario", target = "usuario")
    public abstract Finca toModel(FincaEntidad entidad);

    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "usuario", target = "usuario")
    public abstract FincaEntidad toEntity(Finca finca);
}