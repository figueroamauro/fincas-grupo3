package com.example.fincas_grupo3.domain.ports.in.factura;

import com.example.fincas_grupo3.domain.models.factura.Factura;
import java.util.List;

public interface ObtenerFacturaUseCase {
    Factura obtenerFacturaPorId(Long id);
    List<Factura> obtenerTodasLasFacturas();
}