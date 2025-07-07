package com.example.fincas_grupo3.domain.ports.in.tipoFactura;

import com.example.fincas_grupo3.domain.models.tipoFactura.TipoFactura;


public interface ActualizarTipoFacturaUseCase {
    TipoFactura actualizarTipoFactura(TipoFactura tipoFactura);
}