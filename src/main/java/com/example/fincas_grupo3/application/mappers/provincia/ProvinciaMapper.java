package com.example.fincas_grupo3.application.mappers.provincia;

import com.example.fincas_grupo3.application.dto.provincia.ProvinciaRequestDTO;
import com.example.fincas_grupo3.application.dto.provincia.ProvinciaResponseDTO;
import com.example.fincas_grupo3.domain.models.provincia.Provincia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",implementationName = "provinciaMapperApplication")
public abstract class ProvinciaMapper {


    public abstract Provincia toModel(ProvinciaRequestDTO provinciaRequestDTO);


    public abstract ProvinciaResponseDTO ToDTO(Provincia provincia);

}
