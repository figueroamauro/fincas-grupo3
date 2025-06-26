package com.example.fincas_grupo3.domain.ports.in.reserva;


import com.example.fincas_grupo3.domain.models.reserva.Reserva;

public interface EliminarReservaUseCase {

    Boolean eliminarReserva(Reserva reserva);
    Boolean eliminarReservaPorId(Long id);
}
