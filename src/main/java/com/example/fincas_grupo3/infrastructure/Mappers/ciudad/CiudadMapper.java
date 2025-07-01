package com.example.fincas_grupo3.infrastructure.Mappers.ciudad;

import com.example.fincas_grupo3.application.exceptions.ProvinciaNoEncontradaException;
import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import com.example.fincas_grupo3.infrastructure.entities.ciudad.CiudadEntidad;
import com.example.fincas_grupo3.infrastructure.entities.provincia.ProvinciaEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.provincia.JPAProvinciaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", implementationName = "ciudadMapperInfra")
public abstract class CiudadMapper {

    @Autowired
    private JPAProvinciaRepository jpaProvinciaRepository;



    @Mapping(source = "provincia.id", target = "provincia", qualifiedByName = "mapProvinciaIdToProvinciaEntity")
    public abstract CiudadEntidad toEntity(Ciudad ciudad);

    @Mapping(target = "provincia", source = "provincia")
    public abstract Ciudad toModel(CiudadEntidad ciudadEntidad);


    @Named("mapProvinciaIdToProvinciaEntity")
    protected ProvinciaEntidad mapProvinciaIdToProvinciaEntity(Long provinciaId) {
        if (provinciaId == null) {
            return null;
        }
        return jpaProvinciaRepository.findById(provinciaId)
                .orElseThrow(() -> new ProvinciaNoEncontradaException("Provincia con id " + provinciaId + " no encontrada al mapear la ciudad."));
    }
}
