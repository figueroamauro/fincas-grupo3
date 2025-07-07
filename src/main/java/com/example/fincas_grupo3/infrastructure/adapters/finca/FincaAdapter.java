package com.example.fincas_grupo3.infrastructure.adapters.finca;

import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.ports.out.finca.FincaOutPort;
import com.example.fincas_grupo3.infrastructure.mappers.finca.FincaMapper;
import com.example.fincas_grupo3.infrastructure.entities.finca.FincaEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.finca.JPAFincaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FincaAdapter implements FincaOutPort {
    private final JPAFincaRepository fincaRepository;
    private final FincaMapper fincaMapper;

    public FincaAdapter(JPAFincaRepository fincaRepository, FincaMapper fincaMapper) {
        this.fincaRepository = fincaRepository;
        this.fincaMapper = fincaMapper;
    }


    @Override
    public Finca guardar(Finca finca) {
        FincaEntidad entidad = fincaMapper.toEntity(finca);
        FincaEntidad entidadGuardada = fincaRepository.save(entidad);

        return fincaMapper.toModel(entidadGuardada);
    }

    @Override
    public Finca actualizar(Finca finca) {
        FincaEntidad entidad = fincaMapper.toEntity(finca);
        FincaEntidad entidadGuardada = fincaRepository.save(entidad);

        return fincaMapper.toModel(entidadGuardada);
    }

    @Override
    public List<Finca> obetenerTodas() {
        return fincaRepository.findAll().stream().map(fincaMapper::toModel).toList();
    }

    @Override
    public Finca obtenerPorId(Long id) {
        Optional<FincaEntidad> fincaEncontrada = fincaRepository.findById(id);
        if (fincaEncontrada.isPresent()) {
            return fincaEncontrada.map(fincaMapper::toModel).get();
        }
        return null;
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        fincaRepository.deleteById(id);
        return true;
    }
}
