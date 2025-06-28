package com.example.fincas_grupo3.infrastructure.controllers.horario;

import com.example.fincas_grupo3.application.dto.horario.HorarioDisponibleRequestDTO;
import com.example.fincas_grupo3.application.dto.horario.HorarioDisponibleResponseDTO;
import com.example.fincas_grupo3.application.services.horario.HorarioDisponibleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioDisponibleController {
    private final HorarioDisponibleService horarioDisponibleService;

    public HorarioDisponibleController(HorarioDisponibleService horarioDisponibleService) {
        this.horarioDisponibleService = horarioDisponibleService;
    }

    @PostMapping
    public ResponseEntity<HorarioDisponibleResponseDTO> create(@RequestBody HorarioDisponibleRequestDTO dto) {
        HorarioDisponibleResponseDTO response = horarioDisponibleService.guardar(dto);
        return ResponseEntity.created(URI.create("/api/horarios/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<HorarioDisponibleResponseDTO>> findAll() {
        List<HorarioDisponibleResponseDTO> response = horarioDisponibleService.obtenerTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioDisponibleResponseDTO> findById(@PathVariable Long id) {
        HorarioDisponibleResponseDTO response = horarioDisponibleService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        horarioDisponibleService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
