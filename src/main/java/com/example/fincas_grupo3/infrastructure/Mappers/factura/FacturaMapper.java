package com.example.fincas_grupo3.infrastructure.Mappers.factura;

import com.example.fincas_grupo3.domain.models.factura.Factura;
import com.example.fincas_grupo3.infrastructure.entities.factura.FacturaEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "facturaMapperInfra")
public abstract class FacturaMapper {
    public abstract Factura toModel(FacturaEntidad entidad);
    public abstract FacturaEntidad toEntity(Factura factura);
}