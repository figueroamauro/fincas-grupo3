package com.example.fincas_grupo3.infrastructure.mappers.pago;

import com.example.fincas_grupo3.domain.models.pago.Pago;
import com.example.fincas_grupo3.infrastructure.entities.pago.PagoEntidad;
import com.example.fincas_grupo3.infrastructure.mappers.estadoPago.EstadoPagoMapper;
import com.example.fincas_grupo3.infrastructure.mappers.reserva.ReservaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {EstadoPagoMapper.class, ReservaMapper.class},
        implementationName = "pagoMapperInfra")
public abstract class PagoMapper {

    @Mapping(source = "estadoPago", target = "estadoPago")
    @Mapping(source = "reserva", target = "reserva")
    public abstract Pago toModel(PagoEntidad entidad);

    @Mapping(source = "estadoPago", target = "estadoPago")
    @Mapping(source = "reserva", target = "reserva")
    public abstract PagoEntidad toEntity(Pago pago);
}