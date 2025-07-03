package com.example.fincas_grupo3.application.mappers.direccion;

import com.example.fincas_grupo3.application.dto.ciudad.CiudadResponseDTO;
import com.example.fincas_grupo3.application.dto.direccion.DireccionRequestDTO;
import com.example.fincas_grupo3.application.dto.direccion.DireccionResponseDTO;
import com.example.fincas_grupo3.application.exceptions.CiudadNoEncontradaException;
import com.example.fincas_grupo3.application.services.ciudad.CiudadService;
import com.example.fincas_grupo3.application.usecases.ciudad.CiudadUseCases;
import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", implementationName = "direccionMapperApplication")
public abstract class DireccionMapper {
    @Autowired
    private CiudadUseCases ciudadUseCases;

    @Mapping(source = "ciudadId", target = "ciudad", qualifiedByName = "dtoToCiudad")
    public abstract Direccion toModel(DireccionRequestDTO dto);

    @Mapping(source = "ciudad.nombre", target = "ciudad")
    public abstract DireccionResponseDTO toDTO(Direccion direccion);


    @Named("dtoToCiudad")
    public Ciudad dtoToCiudad(Long id) {
        Ciudad ciudad = ciudadUseCases.obtenerCiudadPorId(id);
        if (ciudad == null) {
            throw new CiudadNoEncontradaException("Ciudad no encontrada");
        }
        return ciudad;
    }
}
