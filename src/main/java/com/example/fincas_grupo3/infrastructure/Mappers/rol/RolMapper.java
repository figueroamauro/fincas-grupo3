package com.example.fincas_grupo3.infrastructure.Mappers.rol;

import com.example.fincas_grupo3.domain.models.rol.Rol;
import com.example.fincas_grupo3.infrastructure.entities.rol.RolEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",implementationName = "rolMapperInfra")
public abstract class RolMapper {

    public abstract Rol toModel(RolEntidad entidad);

    public abstract RolEntidad toEntity(Rol rol);

}
