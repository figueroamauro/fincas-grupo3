package com.example.fincas_grupo3.application.mappers.horario;

import com.example.fincas_grupo3.application.dto.horario.HorarioDisponibleRequestDTO;
import com.example.fincas_grupo3.application.dto.horario.HorarioDisponibleResponseDTO;
import com.example.fincas_grupo3.application.exceptions.FincaNoEncontradaException;
import com.example.fincas_grupo3.application.usecases.finca.FincaUseCases;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", implementationName = "horarioMapperApplication")
public abstract class HorarioDisponibleMapper {
    @Autowired
    private FincaUseCases fincaUseCases;

    @Mapping(source = "fincaId", target = "finca", qualifiedByName = "mapToFinca")
    public abstract HorarioDisponible toModel(HorarioDisponibleRequestDTO dto);

    public abstract HorarioDisponibleResponseDTO toDTO(HorarioDisponible horarioDisponible);

    @Named("mapToFinca")
    public Finca mapToFinca(Long id) {
        Finca finca = fincaUseCases.obtenerFincaPorId(id);
        if (finca == null) {
            throw  new FincaNoEncontradaException("Finca no encontrada");
        }
        return finca;
    }
}
