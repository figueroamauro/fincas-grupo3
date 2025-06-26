package com.example.fincas_grupo3.application.usecases.direccion;
import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.domain.ports.in.direccion.ObtenerDireccionUseCase;
import com.example.fincas_grupo3.domain.ports.out.direccion.DireccionOutPort;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ObtenerDireccionUseCaseImpl implements ObtenerDireccionUseCase {
    private final DireccionOutPort direccionOutPort;

    public ObtenerDireccionUseCaseImpl(DireccionOutPort direccionOutPort) {
        this.direccionOutPort = direccionOutPort;
    }


    @Override
    public List<Direccion> obtenerDirecciones() {
        return direccionOutPort.obtenerTodas();
    }

    @Override
    public Direccion obtenerDireccionPorId(Long id) {
        return direccionOutPort.obtenerPorId(id);
    }


}