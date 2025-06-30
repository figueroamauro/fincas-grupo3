package com.example.fincas_grupo3.application.mappers.tipoFactura;

import com.example.fincas_grupo3.application.dto.tipoFactura.TipoFacturaRequestDTO;
import com.example.fincas_grupo3.application.dto.tipoFactura.TipoFacturaResponseDTO;
import com.example.fincas_grupo3.domain.models.tipoFactura.TipoFactura;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "tipoFacturaMapperApplication")
public abstract class TipoFacturaMapper {
    public abstract TipoFactura toModel(TipoFacturaRequestDTO requestDTO);
    public abstract TipoFacturaResponseDTO toDTO(TipoFactura tipoFactura);
}