package com.example.fincas_grupo3.application.mappers.foto;

import com.example.fincas_grupo3.application.dto.foto.FotoRequestDTO;
import com.example.fincas_grupo3.application.dto.foto.FotoResponseDTO;
import com.example.fincas_grupo3.application.exceptions.FincaNoEncontradaException;
import com.example.fincas_grupo3.application.usecases.finca.FincaUseCases;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.models.foto.Foto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", implementationName = "fotoMapperApplication")
public abstract class FotoMapper {
    @Autowired
    private FincaUseCases fincaUseCases;

    @Mapping(source = "fincaId", target = "finca", qualifiedByName = "mapToFinca")
    public abstract Foto toModel(FotoRequestDTO dto);


    public abstract FotoResponseDTO toDTO(Foto foto);

    @Named("mapToFinca")
    public Finca mapToFinca(Long id) {
        Finca finca = fincaUseCases.obtenerFincaPorId(id);
        if (finca == null) {
            throw new FincaNoEncontradaException("Finca no encontrada");
        }
        return finca;
    }
}
