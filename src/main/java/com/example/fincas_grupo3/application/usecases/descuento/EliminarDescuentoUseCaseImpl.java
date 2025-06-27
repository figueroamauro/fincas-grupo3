package com.example.fincas_grupo3.application.usecases.descuento;

import com.example.fincas_grupo3.domain.ports.in.descuento.EliminarDescuentoUseCase;
import com.example.fincas_grupo3.domain.ports.out.descuento.DescuentoOutPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarDescuentoUseCaseImpl implements EliminarDescuentoUseCase {

    private final DescuentoOutPort descuentoOutPort;

    public EliminarDescuentoUseCaseImpl(DescuentoOutPort descuentoOutPort) {
        this.descuentoOutPort = descuentoOutPort;
    }

    @Override
    public Boolean eliminarDescuentoPorId(Long id) {
        return descuentoOutPort.eliminarPorId(id);
    }

}
