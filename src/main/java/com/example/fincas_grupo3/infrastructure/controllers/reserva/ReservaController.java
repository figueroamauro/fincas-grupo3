package com.example.fincas_grupo3.infrastructure.controllers.reserva;

import com.example.fincas_grupo3.application.dto.reserva.ReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.reserva.ReservaResponseDTO;
import com.example.fincas_grupo3.application.services.reserva.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> create(@RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO response = reservaService.guardar(dto);
        return ResponseEntity.created(URI.create("/api/reservas/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> findAll() {
        List<ReservaResponseDTO> response = reservaService.obtenerTodas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> findById(@PathVariable Long id) {
        ReservaResponseDTO response = reservaService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<ReservaResponseDTO> update(@RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO response = reservaService.actualizar(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        reservaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}