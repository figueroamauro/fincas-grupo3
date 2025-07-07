package com.example.fincas_grupo3.application.mappers.rol;

import com.example.fincas_grupo3.application.dto.rol.RolResponseDTO;
import com.example.fincas_grupo3.domain.models.rol.Rol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",implementationName = "rolMapperApplication")
public abstract class RolMapper {
    public abstract RolResponseDTO toDTO(Rol rol);
    public abstract Rol toModel(RolResponseDTO rolResponseDTO);


}
