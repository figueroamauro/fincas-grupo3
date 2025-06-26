package com.example.fincas_grupo3.ciudades.infrastructure.adapters;

import com.example.fincas_grupo3.ciudades.domain.models.Ciudad;
import com.example.fincas_grupo3.ciudades.domain.ports.out.CiudadOutPort;
import com.example.fincas_grupo3.ciudades.infrastructure.Mappers.CiudadMapper;
import com.example.fincas_grupo3.ciudades.infrastructure.entities.CiudadEntidad;
import com.example.fincas_grupo3.ciudades.infrastructure.repositories.JPACiudadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadAdapter implements CiudadOutPort {

    private final JPACiudadRepository jpaCiudadRepository;

    public CiudadAdapter(JPACiudadRepository jpaCiudadRepository) {
        this.jpaCiudadRepository = jpaCiudadRepository;
    }

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) {
        CiudadEntidad entidad = CiudadMapper.toEntity(ciudad);
        CiudadEntidad entidadGuardada = jpaCiudadRepository.save(entidad);
        return CiudadMapper.toModel(entidadGuardada);
    }

    @Override
    public Ciudad actualizarCiudad(Ciudad ciudad) {
        CiudadEntidad entidad = CiudadMapper.toEntity(ciudad);
        CiudadEntidad entidadGuardada = jpaCiudadRepository.save(entidad);
        return CiudadMapper.toModel(entidadGuardada);
    }

    @Override
    public List<Ciudad> obtenerCiudad() {
        return jpaCiudadRepository.findAll().stream()
                .map(CiudadMapper::toModel)
                .toList();
    }

    @Override
    public Ciudad obtenerCiudadPorId(Long id) {
        Optional<CiudadEntidad> ciudadGuardada = jpaCiudadRepository.findById(id);
        return ciudadGuardada.map(CiudadMapper::toModel).orElse(null);
    }

    @Override
    public Boolean eliminarCiudad(Ciudad ciudad) {
        Optional<CiudadEntidad> ciudadEncontrada = jpaCiudadRepository.findById(ciudad.getId());
        if (ciudadEncontrada.isPresent()) {
            jpaCiudadRepository.delete(ciudadEncontrada.get());
            return true;
        }
        return false;
    }

    @Override
    public Boolean eliminarCiudadPorId(Long id) {
        Optional<CiudadEntidad> ciudadEncontrada = jpaCiudadRepository.findById(id);
        if (ciudadEncontrada.isPresent()) {
            jpaCiudadRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
