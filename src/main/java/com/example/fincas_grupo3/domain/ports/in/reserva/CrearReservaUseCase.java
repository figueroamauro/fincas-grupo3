package com.example.fincas_grupo3.domain.ports.in.reserva;

import com.example.fincas_grupo3.domain.models.reserva.Reserva;

public interface CrearReservaUseCase {

    Reserva crearReserva(Reserva reserva);
}
