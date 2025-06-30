package com.example.fincas_grupo3.infrastructure.Mappers.tipoFactura;

import com.example.fincas_grupo3.domain.models.tipoFactura.TipoFactura;
import com.example.fincas_grupo3.infrastructure.entities.tipoFactura.TipoFacturaEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "tipoFacturaMapperInfra")
public abstract class TipoFacturaMapper {
    public abstract TipoFactura toModel(TipoFacturaEntidad entidad);
    public abstract TipoFacturaEntidad toEntity(TipoFactura tipoFactura);
}