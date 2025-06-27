package com.example.fincas_grupo3.application.usecases.pago;

import com.example.fincas_grupo3.domain.models.pago.Pago;
import com.example.fincas_grupo3.domain.ports.in.pago.CrearPagoUseCase;
import com.example.fincas_grupo3.domain.ports.out.pago.PagoOutPort;
import org.springframework.stereotype.Component;

@Component
public class CrearPagoUseCaseImpl implements CrearPagoUseCase {
    private final PagoOutPort pagoOutPort;

    public CrearPagoUseCaseImpl(PagoOutPort pagoOutPort) {
        this.pagoOutPort = pagoOutPort;
    }

    @Override
    public Pago crearPago(Pago pago) {
        return pagoOutPort.save(pago);
    }
}