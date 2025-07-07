package com.example.fincas_grupo3.application.usecases.descuento;

import com.example.fincas_grupo3.domain.models.descuento.Descuento;
import com.example.fincas_grupo3.domain.ports.in.descuento.ObtenerDescuentoUseCase;
import com.example.fincas_grupo3.domain.ports.out.descuento.DescuentoOutPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerDescuentoUseCaseImpl implements ObtenerDescuentoUseCase {
    private final DescuentoOutPort descuentoOutPort;

    public ObtenerDescuentoUseCaseImpl(DescuentoOutPort descuentoOutPort) {
        this.descuentoOutPort = descuentoOutPort;
    }


    @Override
    public List<Descuento> obtenerDescuentos() {
        return descuentoOutPort.obtenerTodas();
    }

    @Override
    public Descuento obtenerDescuentoPorId(Long id) {
        return descuentoOutPort.obtenerPorId(id);
    }


}
