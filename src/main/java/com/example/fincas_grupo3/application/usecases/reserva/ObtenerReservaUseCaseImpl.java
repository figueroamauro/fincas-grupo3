package com.example.fincas_grupo3.application.usecases.reserva;

import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import com.example.fincas_grupo3.domain.ports.in.reserva.ObtenerReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.reserva.ReservaOutPort;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ObtenerReservaUseCaseImpl implements ObtenerReservaUseCase {
    private final ReservaOutPort reservaOutPort;
    public ObtenerReservaUseCaseImpl(ReservaOutPort reservaOutPort) { this.reservaOutPort = reservaOutPort; }
    @Override
    public Reserva obtenerReservaPorId(Long id) { return reservaOutPort.obtenerReservasPorId(id); }
    @Override
    public List<Reserva> obtenerReservas() { return reservaOutPort.obtenerReservas(); }
}