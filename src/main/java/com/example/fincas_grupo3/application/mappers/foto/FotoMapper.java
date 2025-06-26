package com.example.fincas_grupo3.application.mappers.foto;

import com.example.fincas_grupo3.application.dto.foto.FotoRequestDTO;
import com.example.fincas_grupo3.application.dto.foto.FotoResponseDTO;
import com.example.fincas_grupo3.domain.models.foto.Foto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "fotoMapperApplication")
public abstract class FotoMapper {

    public abstract Foto toModel(FotoRequestDTO dto);

    public abstract FotoResponseDTO toDTO(Foto foto);
}
