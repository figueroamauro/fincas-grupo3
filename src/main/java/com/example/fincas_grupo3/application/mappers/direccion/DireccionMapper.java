package com.example.fincas_grupo3.application.mappers.direccion;

import com.example.fincas_grupo3.application.dto.direccion.DireccionRequestDTO;
import com.example.fincas_grupo3.application.dto.direccion.DireccionResponseDTO;
import com.example.fincas_grupo3.application.exceptions.CiudadNoEncontradaException;
import com.example.fincas_grupo3.application.mappers.ciudad.CiudadMapper; // Importamos el mapper de ciudad
import com.example.fincas_grupo3.application.usecases.ciudad.CiudadUseCases;
import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = "spring",
        uses = {CiudadMapper.class},
        implementationName = "direccionMapperApplicationImpl")
public abstract class DireccionMapper {
    @Autowired
    protected CiudadUseCases ciudadUseCases;

    @Mapping(source = "ciudadId", target = "ciudad", qualifiedByName = "mapCiudadIdToCiudad")
    public abstract Direccion toModel(DireccionRequestDTO dto);


    @Mapping(source = "ciudad.nombre", target = "ciudad")
    public abstract DireccionResponseDTO toDTO(Direccion direccion);

    @Named("mapCiudadIdToCiudad")
    public Ciudad mapCiudadIdToCiudad(Long id) {
        if (id == null) {
            return null;
        }
        Ciudad ciudad = ciudadUseCases.obtenerCiudadPorId(id);
        if (ciudad == null) {
            throw new CiudadNoEncontradaException("Ciudad con id " + id + " no encontrada.");
        }
        return ciudad;
    }
}