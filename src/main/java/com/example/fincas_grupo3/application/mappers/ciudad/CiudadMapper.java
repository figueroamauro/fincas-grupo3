package com.example.fincas_grupo3.application.mappers.ciudad;

import com.example.fincas_grupo3.application.dto.ciudad.CiudadRequestDTO;
import com.example.fincas_grupo3.application.dto.ciudad.CiudadResponseDTO;
import com.example.fincas_grupo3.application.exceptions.ProvinciaNoEncontradaException;
import com.example.fincas_grupo3.application.usecases.provincia.ProvinciaUseCases;
import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import com.example.fincas_grupo3.domain.models.provincia.Provincia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", implementationName = "ciudadMapperApplication")
public abstract class CiudadMapper {

    @Autowired
    protected ProvinciaUseCases provinciaUseCases;

    @Mapping(source = "provinciaId", target = "provincia", qualifiedByName = "mapProvinciaIdToProvincia")
    public abstract Ciudad toModel(CiudadRequestDTO dto);

    @Mapping(source = "provincia.nombre", target = "nombreProvincia")
    public abstract CiudadResponseDTO toDTO(Ciudad ciudad);

    @Named("mapProvinciaIdToProvincia")
    protected Provincia mapProvinciaIdToProvincia(Long provinciaId) {

        Provincia provincia = provinciaUseCases.obtenerProvinciaPorId(provinciaId);
        if(provincia == null) {
            throw new ProvinciaNoEncontradaException("Provincia con id " + provinciaId + " no encontrada.");
        }
        return provincia;
    }
}