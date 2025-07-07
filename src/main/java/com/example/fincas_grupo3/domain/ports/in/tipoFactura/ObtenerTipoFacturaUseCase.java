package com.example.fincas_grupo3.domain.ports.in.tipoFactura;

import com.example.fincas_grupo3.domain.models.tipoFactura.TipoFactura;

import java.util.List;

public interface ObtenerTipoFacturaUseCase {
    TipoFactura obtenerTipoFacturaPorId(Long id);
    List<TipoFactura> obtenerTodosLosTiposFactura();
}