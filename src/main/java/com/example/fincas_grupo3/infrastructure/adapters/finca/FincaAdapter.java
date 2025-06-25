package com.example.fincas_grupo3.infrastructure.adapters.finca;

import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.ports.out.finca.FincaOutPort;
import com.example.fincas_grupo3.infrastructure.Mappers.finca.FincaMapper;
import com.example.fincas_grupo3.infrastructure.entities.finca.FincaEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.finca.JPAFincaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return fincaRepository.findById(id).map(fincaMapper::toModel).get();
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        fincaRepository.deleteById(id);
        return true;
    }
}
