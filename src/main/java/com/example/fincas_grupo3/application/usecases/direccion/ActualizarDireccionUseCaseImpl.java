package com.example.fincas_grupo3.application.usecases.direccion;

import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.domain.ports.in.direccion.ActualizarDireccionUseCase;
import com.example.fincas_grupo3.domain.ports.out.direccion.DireccionOutPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarDireccionUseCaseImpl implements ActualizarDireccionUseCase {
    private final DireccionOutPort direccionOutPort;

    public ActualizarDireccionUseCaseImpl(DireccionOutPort direccionOutPort) {
        this.direccionOutPort = direccionOutPort;
    }

    @Override
    public Direccion actualizarDireccion(Direccion direccion) {
        return direccionOutPort.actualizar(direccion);
    }



}
