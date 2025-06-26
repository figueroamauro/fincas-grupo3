package com.example.fincas_grupo3.application.usecases.reserva;

import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import com.example.fincas_grupo3.domain.ports.in.reserva.CrearReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.reserva.ReservaOutPort;
import org.springframework.stereotype.Component;

@Component
public class CrearReservaUseCaseImpl implements CrearReservaUseCase {
    private final ReservaOutPort reservaOutPort;
    public CrearReservaUseCaseImpl(ReservaOutPort reservaOutPort) { this.reservaOutPort = reservaOutPort; }
    @Override
    public Reserva crearReserva(Reserva reserva) { return reservaOutPort.crearReserva(reserva); }
}