package com.example.fincas_grupo3.infrastructure.Mappers.ciudad;

import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import com.example.fincas_grupo3.infrastructure.entities.ciudad.CiudadEntidad;

public class CiudadMapper {

    public static CiudadEntidad toEntity(Ciudad ciudad) {
        return new CiudadEntidad(
                ciudad.getId(),
                ciudad.getNombre()
        );
    }

    public static Ciudad toModel(CiudadEntidad entidad) {
        return new Ciudad(
                entidad.getId(),
                entidad.getNombre()
        );
    }
}
