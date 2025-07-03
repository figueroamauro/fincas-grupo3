package com.example.fincas_grupo3.application.mappers.usuario;

import com.example.fincas_grupo3.application.dto.usuario.UsuarioRequestDTO;
import com.example.fincas_grupo3.application.dto.usuario.UsuarioResponseDTO;
import com.example.fincas_grupo3.application.exceptions.DireccionNoEncontradaException;
import com.example.fincas_grupo3.application.mappers.direccion.DireccionMapper;
import com.example.fincas_grupo3.application.usecases.direccion.DireccionUseCases;
import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;


@Primary
@Mapper(componentModel = "spring",
        uses = {DireccionMapper.class}, // Delegamos la conversión de Dirección
        implementationName = "usuarioMapperApplication")
public abstract class UsuarioMapper {

    @Autowired
    protected DireccionUseCases direccionUseCases;

    @Mapping(source = "direccionId", target = "direccion", qualifiedByName = "mapDireccionIdToDireccion")
    public abstract Usuario toModel(UsuarioRequestDTO dto);

    @Mapping(target = "roles", ignore = true)
    @Mapping(source = "direccion", target = "direccion")
    public abstract UsuarioResponseDTO toDTO(Usuario usuario);

    @Named("mapDireccionIdToDireccion")
    protected Direccion mapDireccionIdToDireccion(Long direccionId) {
        if (direccionId == null) {
            return null;
        }
        Direccion direccion = direccionUseCases.obtenerDireccionPorId(direccionId);
        if (direccion == null) {
            throw new DireccionNoEncontradaException("Direccion con id " + direccionId + " no encontrada.");
        }
        return direccion;
    }
}