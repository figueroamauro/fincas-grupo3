package com.example.fincas_grupo3.domain.ports.in.ciudad;
import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import java.util.List;


public interface ObtenerCiudadUseCase {
    List<Ciudad> obtenerCiudades();

    Ciudad obtenerCiudadPorId(Long id);

}
