package com.example.fincas_grupo3.infrastructure.adapters.tiporeserva;

import com.example.fincas_grupo3.application.exceptions.TipoReservaNoEncontradoException;
import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import com.example.fincas_grupo3.domain.ports.out.tiporeserva.TipoReservaOutPort;
import com.example.fincas_grupo3.infrastructure.mappers.tiporeserva.TipoReservaMapper;
import com.example.fincas_grupo3.infrastructure.entities.tiporeserva.TipoReservaEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.tiporeserva.JPATipoReservaRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TipoReservaAdapter implements TipoReservaOutPort {

    private final JPATipoReservaRepository tipoReservaRepository;
    private final TipoReservaMapper tipoReservaMapper;

    public TipoReservaAdapter(JPATipoReservaRepository tipoReservaRepository, TipoReservaMapper tipoReservaMapper) {
        this.tipoReservaRepository = tipoReservaRepository;
        this.tipoReservaMapper = tipoReservaMapper;
    }

    @Override
    public TipoReserva save(TipoReserva tipoReserva) {
        TipoReservaEntidad entidad = tipoReservaMapper.toEntity(tipoReserva);
        return tipoReservaMapper.toModel(tipoReservaRepository.save(entidad));
    }

    @Override
    public TipoReserva update(TipoReserva tipoReserva) {
        TipoReservaEntidad entidad = tipoReservaMapper.toEntity(tipoReserva);
        return tipoReservaMapper.toModel(tipoReservaRepository.save(entidad));
    }

    @Override
    public TipoReserva findById(Long id) {
        return tipoReservaRepository.findById(id)
                .map(tipoReservaMapper::toModel)
                .orElseThrow(() -> new TipoReservaNoEncontradoException("Tipo de reserva no encontrado con id: " + id));
    }

    @Override
    public List<TipoReserva> findAll() {
        return tipoReservaRepository.findAll().stream()
                .map(tipoReservaMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        if (tipoReservaRepository.existsById(id)) {
            tipoReservaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}