package com.example.fincas_grupo3.domain.ports.in.reserva;


import com.example.fincas_grupo3.domain.models.reserva.Reserva;

import java.util.List;

public interface ObtenerReservaUseCase {

    List<Reserva> obtenerReservas();

    Reserva obtenerReservaPorId(Long id);
}
