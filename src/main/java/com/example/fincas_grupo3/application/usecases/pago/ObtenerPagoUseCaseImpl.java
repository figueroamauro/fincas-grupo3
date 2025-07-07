package com.example.fincas_grupo3.application.usecases.pago;

import com.example.fincas_grupo3.domain.models.pago.Pago;
import com.example.fincas_grupo3.domain.ports.in.pago.ObtenerPagoUseCase;
import com.example.fincas_grupo3.domain.ports.out.pago.PagoOutPort;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ObtenerPagoUseCaseImpl implements ObtenerPagoUseCase {
    private final PagoOutPort pagoOutPort;

    public ObtenerPagoUseCaseImpl(PagoOutPort pagoOutPort) {
        this.pagoOutPort = pagoOutPort;
    }

    @Override
    public Pago obtenerPagoPorId(Long id) {
        return pagoOutPort.findById(id);
    }

    @Override
    public List<Pago> obtenerTodosLosPagos() {
        return pagoOutPort.findAll();
    }
}