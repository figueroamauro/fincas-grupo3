package com.example.fincas_grupo3.infrastructure.controllers.tiporeserva;

import com.example.fincas_grupo3.application.dto.tiporeserva.TipoReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.tiporeserva.TipoReservaResponseDTO;
import com.example.fincas_grupo3.application.services.tiporeserva.TipoReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-reserva")
public class TipoReservaController {

    private final TipoReservaService tipoReservaService;

    public TipoReservaController(TipoReservaService tipoReservaService) {
        this.tipoReservaService = tipoReservaService;
    }

    @PostMapping
    public ResponseEntity<TipoReservaResponseDTO> create(@RequestBody TipoReservaRequestDTO requestDTO) {
        TipoReservaResponseDTO responseDTO = tipoReservaService.crearTipoReserva(requestDTO);
        return ResponseEntity.created(URI.create("/api/tipos-reserva/" + responseDTO.getId())).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<TipoReservaResponseDTO>> findAll() {
        return ResponseEntity.ok(tipoReservaService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoReservaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoReservaService.obtenerPorId(id));
    }

    @PutMapping
    public ResponseEntity<TipoReservaResponseDTO> update(@RequestBody TipoReservaRequestDTO requestDTO) {
        return ResponseEntity.ok(tipoReservaService.actualizarTipoReserva(requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tipoReservaService.eliminarTipoReserva(id);
        return ResponseEntity.noContent().build();
    }
}