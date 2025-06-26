package com.example.fincas_grupo3.infrastructure.adapters.factura;

import com.example.fincas_grupo3.application.exceptions.FacturaNoEncontradaException;
import com.example.fincas_grupo3.domain.models.factura.Factura;
import com.example.fincas_grupo3.domain.ports.out.factura.FacturaOutPort;
import com.example.fincas_grupo3.infrastructure.Mappers.factura.FacturaMapper;
import com.example.fincas_grupo3.infrastructure.entities.factura.FacturaEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.factura.JPAFacturaRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FacturaAdapter implements FacturaOutPort {

    private final JPAFacturaRepository facturaRepository;
    private final FacturaMapper facturaMapper;

    public FacturaAdapter(JPAFacturaRepository facturaRepository, FacturaMapper facturaMapper) {
        this.facturaRepository = facturaRepository;
        this.facturaMapper = facturaMapper;
    }

    @Override
    public Factura save(Factura factura) {
        FacturaEntidad entidad = facturaMapper.toEntity(factura);
        return facturaMapper.toModel(facturaRepository.save(entidad));
    }

    @Override
    public Factura update(Factura factura) {
        FacturaEntidad entidad = facturaMapper.toEntity(factura);
        return facturaMapper.toModel(facturaRepository.save(entidad));
    }

    @Override
    public Factura findById(Long id) {
        return facturaRepository.findById(id)
                .map(entidad -> facturaMapper.toModel(entidad))
                .orElseThrow(() -> new FacturaNoEncontradaException("Factura no encontrada con id: " + id));
    }

    @Override
    public List<Factura> findAll() {
        return facturaRepository.findAll().stream()
                .map(entidad -> facturaMapper.toModel(entidad))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        if (facturaRepository.existsById(id)) {
            facturaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}