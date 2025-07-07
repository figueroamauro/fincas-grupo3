package com.example.fincas_grupo3.application.usecases.reserva;

import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import com.example.fincas_grupo3.domain.ports.in.reserva.EliminarReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.reserva.ReservaOutPort;
import org.springframework.stereotype.Component;

@Component
public class EliminarReservaUseCaseImpl implements EliminarReservaUseCase {
    private final ReservaOutPort reservaOutPort;
    public EliminarReservaUseCaseImpl(ReservaOutPort reservaOutPort) { this.reservaOutPort = reservaOutPort; }
    @Override
    public Boolean eliminarReserva(Reserva reserva) { return reservaOutPort.eliminarReserva(reserva); }
    @Override
    public Boolean eliminarReservaPorId(Long id) { return reservaOutPort.eliminarReservaPorId(id); }
}