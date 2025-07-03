package com.example.fincas_grupo3.infrastructure.mappers.usuario;

import com.example.fincas_grupo3.application.exceptions.DireccionNoEncontradaException;
import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import com.example.fincas_grupo3.infrastructure.entities.direccion.DireccionEntidad;
import com.example.fincas_grupo3.infrastructure.entities.usuario.UsuarioEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.direccion.JPADireccionRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring", implementationName = "usuarioMapperInfra")
public abstract class UsuarioMapper {

    @Autowired
    protected JPADireccionRepository jpaDireccionRepository;


    @Mapping(source = "direccion", target = "direccion")
    public abstract UsuarioEntidad toEntity(Usuario usuario);


    @Mapping(source = "direccion", target = "direccion")
    public abstract Usuario toModel(UsuarioEntidad entidad);


//    @Named("mapDireccionIdToDireccionEntity")
//    protected DireccionEntidad mapDireccionIdToDireccionEntity(Long direccionId) {
//        if (direccionId == null) {
//            return null;
//        }
//        return jpaDireccionRepository.findById(direccionId)
//                .orElseThrow(() -> new DireccionNoEncontradaException("La dirección con id " + direccionId + " asignada al usuario no fue encontrada."));
//    }
}