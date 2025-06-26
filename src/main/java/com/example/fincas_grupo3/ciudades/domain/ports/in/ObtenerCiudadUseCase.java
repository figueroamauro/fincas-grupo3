package com.example.fincas_grupo3.ciudades.domain.ports.in;
import com.example.fincas_grupo3.ciudades.domain.models.Ciudad;
import java.util.List;


public interface ObtenerCiudadUseCase {
    List<Ciudad> obtenerCiudades();

    Ciudad obtenerCiudadPorId(Long id);

}
