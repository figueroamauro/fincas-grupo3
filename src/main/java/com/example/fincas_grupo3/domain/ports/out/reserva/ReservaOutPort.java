package com.example.fincas_grupo3.domain.ports.out.reserva;

import com.example.fincas_grupo3.domain.models.reserva.Reserva;


import java.util.List;


public interface ReservaOutPort {
    Reserva crearReserva(Reserva reserva);

    Reserva actualizarReserva(Reserva reserva);

    List<Reserva> obtenerReservas();

    Reserva obtenerReservasPorId(Long id);

    Boolean eliminarReserva(Reserva reserva);

    Boolean eliminarReservaPorId(Long id);
}