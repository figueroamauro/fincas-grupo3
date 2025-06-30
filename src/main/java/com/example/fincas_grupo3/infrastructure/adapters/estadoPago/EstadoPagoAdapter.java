package com.example.fincas_grupo3.infrastructure.adapters.estadoPago;

import com.example.fincas_grupo3.application.exceptions.EstadoPagoNoEncontradoException;
import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;
import com.example.fincas_grupo3.domain.ports.out.estadoPago.EstadoPagoOutPort;
import com.example.fincas_grupo3.infrastructure.Mappers.estadoPago.EstadoPagoMapper;
import com.example.fincas_grupo3.infrastructure.entities.estadoPago.EstadoPagoEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.estadoPago.JPAEstadoPagoRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoPagoAdapter implements EstadoPagoOutPort {

    private final JPAEstadoPagoRepository estadoPagoRepository;
    private final EstadoPagoMapper estadoPagoMapper;

    public EstadoPagoAdapter(JPAEstadoPagoRepository estadoPagoRepository, EstadoPagoMapper estadoPagoMapper) {
        this.estadoPagoRepository = estadoPagoRepository;
        this.estadoPagoMapper = estadoPagoMapper;
    }

    @Override
    public EstadoPago save(EstadoPago estadoPago) {
        EstadoPagoEntidad entidad = estadoPagoMapper.toEntity(estadoPago);
        return estadoPagoMapper.toModel(estadoPagoRepository.save(entidad));
    }

    @Override
    public EstadoPago update(EstadoPago estadoPago) {
        EstadoPagoEntidad entidad = estadoPagoMapper.toEntity(estadoPago);
        return estadoPagoMapper.toModel(estadoPagoRepository.save(entidad));
    }

    @Override
    public EstadoPago findById(Long id) {
        return estadoPagoRepository.findById(id)
                .map(entidad -> estadoPagoMapper.toModel(entidad))
                .orElseThrow(() -> new EstadoPagoNoEncontradoException("Estado de pago no encontrado con id: " + id));
    }

    @Override
    public List<EstadoPago> findAll() {
        return estadoPagoRepository.findAll().stream()
                .map(entidad -> estadoPagoMapper.toModel(entidad))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        if (estadoPagoRepository.existsById(id)) {
            estadoPagoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}