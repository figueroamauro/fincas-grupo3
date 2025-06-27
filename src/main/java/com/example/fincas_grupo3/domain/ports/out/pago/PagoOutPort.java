package com.example.fincas_grupo3.domain.ports.out.pago;

import com.example.fincas_grupo3.domain.models.pago.Pago;
import java.util.List;

public interface PagoOutPort {
    Pago save(Pago pago);
    Pago findById(Long id);
    List<Pago> findAll();
    Pago update(Pago pago);
    boolean deleteById(Long id);
}