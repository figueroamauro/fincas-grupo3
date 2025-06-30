package com.example.fincas_grupo3.domain.ports.in.estadoreserva;

import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;

public interface CrearEstadoReservaUseCase {
    EstadoReserva crearEstadoReserva(EstadoReserva estadoReserva);
}