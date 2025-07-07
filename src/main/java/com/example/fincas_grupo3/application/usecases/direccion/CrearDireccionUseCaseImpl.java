package com.example.fincas_grupo3.application.usecases.direccion;

import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.domain.ports.in.direccion.CrearDireccionUseCase;
import com.example.fincas_grupo3.domain.ports.out.direccion.DireccionOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearDireccionUseCaseImpl implements CrearDireccionUseCase {
    private final DireccionOutPort direccionOutPort;
    public CrearDireccionUseCaseImpl(DireccionOutPort direccionOutPort) {
        this.direccionOutPort = direccionOutPort;
    }
    @Override
    public Direccion crearDireccion(Direccion direccion) {
       return direccionOutPort.guardar(direccion);
    }
}
