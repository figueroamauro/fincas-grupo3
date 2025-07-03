package com.example.fincas_grupo3.infrastructure.mappers.pago;

import com.example.fincas_grupo3.domain.models.pago.Pago;
import com.example.fincas_grupo3.infrastructure.entities.pago.PagoEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "pagoMapperInfra")
public abstract class PagoMapper {
    public abstract Pago toModel(PagoEntidad entidad);
    public abstract PagoEntidad toEntity(Pago pago);
}