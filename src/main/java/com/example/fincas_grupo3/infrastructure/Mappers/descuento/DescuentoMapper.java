package com.example.fincas_grupo3.infrastructure.Mappers.descuento;

import com.example.fincas_grupo3.domain.models.descuento.Descuento;
import com.example.fincas_grupo3.infrastructure.entities.descuento.DescuentoEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "descuentoMapperInfra")
public abstract class DescuentoMapper {

    public abstract Descuento toModel(DescuentoEntidad descuentoEntidad);
    public abstract DescuentoEntidad toEntity(Descuento descuento);
}
