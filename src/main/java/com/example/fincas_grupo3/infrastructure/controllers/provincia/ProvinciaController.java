package com.example.fincas_grupo3.infrastructure.controllers.provincia;

import com.example.fincas_grupo3.application.dto.provincia.ProvinciaRequestDTO;
import com.example.fincas_grupo3.application.dto.provincia.ProvinciaResponseDTO;
import com.example.fincas_grupo3.application.services.provincia.ProvinciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {

    private final ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @PostMapping
    public ResponseEntity<ProvinciaResponseDTO> create(@RequestBody ProvinciaRequestDTO dto) {
        ProvinciaResponseDTO response = provinciaService.guardar(dto);
        return ResponseEntity.created(URI.create("/api/provincias/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProvinciaResponseDTO>> findAll() {
        List<ProvinciaResponseDTO> response = provinciaService.obtenerTodas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvinciaResponseDTO> findById(@PathVariable Long id) {
        ProvinciaResponseDTO response = provinciaService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<ProvinciaResponseDTO> update(@RequestBody ProvinciaRequestDTO dto) {

        ProvinciaResponseDTO response = provinciaService.actualizar(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        provinciaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}