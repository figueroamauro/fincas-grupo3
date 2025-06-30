package com.example.fincas_grupo3.domain.ports.out.estadoPago;

import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;

import java.util.List;

public interface EstadoPagoOutPort {

    EstadoPago save(EstadoPago EstadoPago);
    EstadoPago findById(Long id);
    List<EstadoPago> findAll();
    EstadoPago update(EstadoPago EstadoPago);
    boolean deleteById(Long id);
}
