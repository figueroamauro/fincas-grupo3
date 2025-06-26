package com.example.fincas_grupo3.domain.ports.out.factura;

import com.example.fincas_grupo3.domain.models.factura.Factura;
import java.util.List;

public interface FacturaOutPort {
    Factura save(Factura factura);
    Factura findById(Long id);
    List<Factura> findAll();
    Factura update(Factura factura);
    boolean deleteById(Long id);
}