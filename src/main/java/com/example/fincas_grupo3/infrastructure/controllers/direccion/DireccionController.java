package com.example.fincas_grupo3.infrastructure.controllers.direccion;

import com.example.fincas_grupo3.application.dto.direccion.DireccionRequestDTO;
import com.example.fincas_grupo3.application.dto.direccion.DireccionResponseDTO;
import com.example.fincas_grupo3.application.services.direccion.DireccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping
    public ResponseEntity<DireccionResponseDTO> create(@RequestBody DireccionRequestDTO dto) {
        DireccionResponseDTO response = direccionService.guardar(dto);
        return ResponseEntity.created(URI.create("/api/direcciones/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DireccionResponseDTO>> findAll() {
        List<DireccionResponseDTO> response = direccionService.obtenerTodas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionResponseDTO> findById(@PathVariable Long id) {
        DireccionResponseDTO response = direccionService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<DireccionResponseDTO> update(@RequestBody DireccionRequestDTO dto) {
        DireccionResponseDTO response = direccionService.actualizar(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        direccionService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
