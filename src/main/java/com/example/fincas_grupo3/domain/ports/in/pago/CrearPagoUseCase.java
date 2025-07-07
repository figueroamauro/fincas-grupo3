package com.example.fincas_grupo3.domain.ports.in.pago;

import com.example.fincas_grupo3.domain.models.pago.Pago;

public interface CrearPagoUseCase {
    Pago crearPago(Pago pago);
}