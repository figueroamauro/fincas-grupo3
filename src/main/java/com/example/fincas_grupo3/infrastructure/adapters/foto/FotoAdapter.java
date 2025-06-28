package com.example.fincas_grupo3.infrastructure.adapters.foto;

import com.example.fincas_grupo3.domain.models.foto.Foto;
import com.example.fincas_grupo3.domain.ports.out.foto.FotoOutPort;
import com.example.fincas_grupo3.infrastructure.Mappers.foto.FotoMapper;
import com.example.fincas_grupo3.infrastructure.entities.foto.FotoEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.foto.JPAFotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotoAdapter implements FotoOutPort {
    private final JPAFotoRepository fotoRepository;
    private final FotoMapper fotoMapper;

    public FotoAdapter(JPAFotoRepository fotoRepository, FotoMapper fotoMapper) {
        this.fotoRepository = fotoRepository;
        this.fotoMapper = fotoMapper;
    }

    @Override
    public Foto guardar(Foto foto) {
        FotoEntidad entidad = fotoMapper.toEntity(foto);
        FotoEntidad entidadGuardada = fotoRepository.save(entidad);

        return fotoMapper.toModel(entidadGuardada);
    }

    @Override
    public List<Foto> obtenerTodas() {
        return fotoRepository.findAll().stream().map(fotoMapper::toModel).toList();
    }

    @Override
    public Foto obtenerPorId(Long id) {
        Optional<FotoEntidad> fotoEncontrada = fotoRepository.findById(id);
        if (fotoEncontrada.isPresent()) {
            return fotoEncontrada.map(fotoMapper::toModel).get();
        }
        return null;
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        fotoRepository.deleteById(id);
        return true;
    }
}
