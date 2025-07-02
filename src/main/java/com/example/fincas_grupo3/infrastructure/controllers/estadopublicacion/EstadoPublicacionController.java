package com.example.fincas_grupo3.infrastructure.controllers.estadopublicacion;

import com.example.fincas_grupo3.application.dto.estadopublicacion.EstadoPublicacionRequestDTO;
import com.example.fincas_grupo3.application.dto.estadopublicacion.EstadoPublicacionResponseDTO;
import com.example.fincas_grupo3.application.services.estadopublicacion.EstadoPublicacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/estadopublicaciones")
public class EstadoPublicacionController {

    private final EstadoPublicacionService estadoPublicacionService;

    public EstadoPublicacionController(EstadoPublicacionService estadoPublicacionService) {
        this.estadoPublicacionService = estadoPublicacionService;
    }

    @PostMapping
    public ResponseEntity<EstadoPublicacionResponseDTO> create(@RequestBody EstadoPublicacionRequestDTO dto) {
        EstadoPublicacionResponseDTO response = estadoPublicacionService.guardar(dto);
        return ResponseEntity.created(URI.create("/api/estadopublicaciones/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EstadoPublicacionResponseDTO>> findAll() {
        List<EstadoPublicacionResponseDTO> response = estadoPublicacionService.obtenerTodas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPublicacionResponseDTO> findById(@PathVariable Long id) {
        EstadoPublicacionResponseDTO response = estadoPublicacionService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<EstadoPublicacionResponseDTO> update(@RequestBody EstadoPublicacionRequestDTO dto) {
        EstadoPublicacionResponseDTO response = estadoPublicacionService.actualizar(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        estadoPublicacionService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
