package com.example.fincas_grupo3.infrastructure.controllers.finca;

import com.example.fincas_grupo3.application.dto.finca.FincaRequestDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;
import com.example.fincas_grupo3.application.services.finca.FincaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fincas")
public class FincaController {

    private final FincaService fincaService;

    public FincaController(FincaService fincaService) {
        this.fincaService = fincaService;
    }

    @PostMapping
    public ResponseEntity<FincaResponseDTO> create(@RequestBody FincaRequestDTO dto) {
        FincaResponseDTO response = fincaService.guardar(dto);
        return ResponseEntity.created(URI.create("/api/fincas/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FincaResponseDTO>> findAll() {
        List<FincaResponseDTO> response = fincaService.obetenerTodas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FincaResponseDTO> findById(@PathVariable Long id) {
        FincaResponseDTO response = fincaService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<FincaResponseDTO> update(@RequestBody FincaRequestDTO dto) {
        FincaResponseDTO response = fincaService.actualizar(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        fincaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
