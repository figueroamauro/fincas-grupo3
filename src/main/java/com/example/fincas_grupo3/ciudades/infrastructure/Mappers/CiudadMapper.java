package com.example.fincas_grupo3.ciudades.infrastructure.Mappers;

import com.example.fincas_grupo3.ciudades.domain.models.Ciudad;
import com.example.fincas_grupo3.ciudades.infrastructure.entities.CiudadEntidad;

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
