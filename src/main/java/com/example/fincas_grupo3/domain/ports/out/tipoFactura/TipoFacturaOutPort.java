package com.example.fincas_grupo3.domain.ports.out.tipoFactura;

import com.example.fincas_grupo3.domain.models.tipoFactura.TipoFactura;

import java.util.List;

public interface TipoFacturaOutPort {
    TipoFactura save(TipoFactura tipoFactura);
    TipoFactura findById(Long id);
    List<TipoFactura> findAll();
    TipoFactura update(TipoFactura tipoFactura);
    boolean deleteById(Long id);
}
