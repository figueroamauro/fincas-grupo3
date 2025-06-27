package com.example.fincas_grupo3.application.usecases.pago;

import com.example.fincas_grupo3.domain.models.pago.Pago;
import com.example.fincas_grupo3.domain.ports.in.pago.ActualizarPagoUseCase;
import com.example.fincas_grupo3.domain.ports.out.pago.PagoOutPort;
import org.springframework.stereotype.Component;

@Component
public class ActualizarPagoUseCaseImpl implements ActualizarPagoUseCase {
    private final PagoOutPort pagoOutPort;

    public ActualizarPagoUseCaseImpl(PagoOutPort pagoOutPort) {
        this.pagoOutPort = pagoOutPort;
    }

    @Override
    public Pago actualizarPago(Pago pago) {
        return pagoOutPort.update(pago);
    }
}