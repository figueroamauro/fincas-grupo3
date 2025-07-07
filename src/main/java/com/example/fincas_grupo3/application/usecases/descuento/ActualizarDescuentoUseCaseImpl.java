package com.example.fincas_grupo3.application.usecases.descuento;

import com.example.fincas_grupo3.domain.models.descuento.Descuento;
import com.example.fincas_grupo3.domain.ports.in.descuento.ActualizarDescuentoUseCase;
import com.example.fincas_grupo3.domain.ports.out.descuento.DescuentoOutPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarDescuentoUseCaseImpl implements ActualizarDescuentoUseCase {
    private  final DescuentoOutPort descuentoOutPort;

    public ActualizarDescuentoUseCaseImpl(DescuentoOutPort descuentoOutPort) {
        this.descuentoOutPort = descuentoOutPort;
    }

    @Override
    public Descuento actualizarDescuento(Descuento descuento){
        return descuentoOutPort.actualizar(descuento);
    }
}
