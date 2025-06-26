package com.example.fincas_grupo3.application.mappers.factura;

import com.example.fincas_grupo3.application.dto.factura.FacturaRequestDTO;
import com.example.fincas_grupo3.application.dto.factura.FacturaResponseDTO;
import com.example.fincas_grupo3.domain.models.factura.Factura;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "facturaMapperApplication")
public abstract class FacturaMapper {
    public abstract Factura toModel(FacturaRequestDTO requestDTO);
    public abstract FacturaResponseDTO toDTO(Factura factura);
}