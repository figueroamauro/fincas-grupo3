package com.example.fincas_grupo3.domain.ports.in.factura;

import com.example.fincas_grupo3.domain.models.factura.Factura;

public interface ActualizarFacturaUseCase {
    Factura actualizarFactura(Factura factura);
}