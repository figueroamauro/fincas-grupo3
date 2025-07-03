package com.example.fincas_grupo3.application.mappers.finca;

import com.example.fincas_grupo3.application.dto.finca.FincaRequestDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;
import com.example.fincas_grupo3.application.mappers.direccion.DireccionMapper;
import com.example.fincas_grupo3.application.mappers.usuario.UsuarioMapper;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {DireccionMapper.class, UsuarioMapper.class}, // <-- ¡Esta es la clave!
        implementationName = "fincaMapperApplication")
public abstract class FincaMapper {

    @Mapping(source = "direccionId", target = "direccion.id")
    @Mapping(source = "usuarioId", target = "usuario.id")
    public abstract Finca toModel(FincaRequestDTO dto);

    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "usuario", target = "usuario")
    public abstract FincaResponseDTO toDTO(Finca finca);
}