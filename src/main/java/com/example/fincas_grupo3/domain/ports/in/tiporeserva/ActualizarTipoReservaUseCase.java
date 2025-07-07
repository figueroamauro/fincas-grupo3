package com.example.fincas_grupo3.domain.ports.in.tiporeserva;

import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;

public interface ActualizarTipoReservaUseCase {
    TipoReserva actualizarTipoReserva(TipoReserva tipoReserva);
}