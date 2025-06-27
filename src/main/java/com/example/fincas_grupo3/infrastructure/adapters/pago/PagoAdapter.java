package com.example.fincas_grupo3.infrastructure.adapters.pago;

import com.example.fincas_grupo3.application.exceptions.PagoNoEncontradoException;
import com.example.fincas_grupo3.domain.models.pago.Pago;
import com.example.fincas_grupo3.domain.ports.out.pago.PagoOutPort;
import com.example.fincas_grupo3.infrastructure.Mappers.pago.PagoMapper;
import com.example.fincas_grupo3.infrastructure.entities.pago.PagoEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.pago.JPAPagoRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PagoAdapter implements PagoOutPort {

    private final JPAPagoRepository pagoRepository;
    private final PagoMapper pagoMapper;

    public PagoAdapter(JPAPagoRepository pagoRepository, PagoMapper pagoMapper) {
        this.pagoRepository = pagoRepository;
        this.pagoMapper = pagoMapper;
    }

    @Override
    public Pago save(Pago pago) {
        PagoEntidad entidad = pagoMapper.toEntity(pago);
        return pagoMapper.toModel(pagoRepository.save(entidad));
    }

    @Override
    public Pago update(Pago pago) {
        PagoEntidad entidad = pagoMapper.toEntity(pago);
        return pagoMapper.toModel(pagoRepository.save(entidad));
    }

    @Override
    public Pago findById(Long id) {
        return pagoRepository.findById(id)
                .map(entidad -> pagoMapper.toModel(entidad))
                .orElseThrow(() -> new PagoNoEncontradoException("Pago no encontrado con id: " + id));
    }

    @Override
    public List<Pago> findAll() {
        return pagoRepository.findAll().stream()
                .map(entidad -> pagoMapper.toModel(entidad))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        if (pagoRepository.existsById(id)) {
            pagoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}