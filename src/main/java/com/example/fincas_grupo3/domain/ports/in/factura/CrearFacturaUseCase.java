package com.example.fincas_grupo3.domain.ports.in.factura;

import com.example.fincas_grupo3.domain.models.factura.Factura;

public interface CrearFacturaUseCase {
    Factura crearFactura(Factura factura);
}