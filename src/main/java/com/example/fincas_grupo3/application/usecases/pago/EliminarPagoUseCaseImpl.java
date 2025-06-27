package com.example.fincas_grupo3.application.usecases.pago;

import com.example.fincas_grupo3.domain.ports.in.pago.EliminarPagoUseCase;
import com.example.fincas_grupo3.domain.ports.out.pago.PagoOutPort;
import org.springframework.stereotype.Component;

@Component
public class EliminarPagoUseCaseImpl implements EliminarPagoUseCase {
    private final PagoOutPort pagoOutPort;

    public EliminarPagoUseCaseImpl(PagoOutPort pagoOutPort) {
        this.pagoOutPort = pagoOutPort;
    }

    @Override
    public boolean eliminarPagoPorId(Long id) {
        return pagoOutPort.deleteById(id);
    }
}