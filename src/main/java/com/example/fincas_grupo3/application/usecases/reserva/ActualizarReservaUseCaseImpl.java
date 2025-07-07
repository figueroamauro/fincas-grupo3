package com.example.fincas_grupo3.application.usecases.reserva;

import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import com.example.fincas_grupo3.domain.ports.in.reserva.ActualizarReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.reserva.ReservaOutPort;
import org.springframework.stereotype.Component;

@Component
public class ActualizarReservaUseCaseImpl implements ActualizarReservaUseCase {
    private final ReservaOutPort reservaOutPort;
    public ActualizarReservaUseCaseImpl(ReservaOutPort reservaOutPort) { this.reservaOutPort = reservaOutPort; }
    @Override
    public Reserva actualizarReserva(Reserva reserva) { return reservaOutPort.actualizarReserva(reserva); }
}