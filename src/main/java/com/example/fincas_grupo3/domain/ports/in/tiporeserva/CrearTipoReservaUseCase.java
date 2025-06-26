package com.example.fincas_grupo3.domain.ports.in.tiporeserva;

import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;

public interface CrearTipoReservaUseCase {
    TipoReserva crearTipoReserva(TipoReserva tipoReserva);
}