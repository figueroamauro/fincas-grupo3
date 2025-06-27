package com.example.fincas_grupo3.infrastructure.controllers.pago;

import com.example.fincas_grupo3.application.dto.pago.PagoRequestDTO;
import com.example.fincas_grupo3.application.dto.pago.PagoResponseDTO;
import com.example.fincas_grupo3.application.services.pago.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<PagoResponseDTO> create(@RequestBody PagoRequestDTO requestDTO) {
        PagoResponseDTO responseDTO = pagoService.crearPago(requestDTO);
        return ResponseEntity.created(URI.create("/api/pagos/" + responseDTO.getId())).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PagoResponseDTO>> findAll() {
        return ResponseEntity.ok(pagoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.obtenerPorId(id));
    }

    @PutMapping
    public ResponseEntity<PagoResponseDTO> update(@RequestBody PagoRequestDTO requestDTO) {
        return ResponseEntity.ok(pagoService.actualizarPago(requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pagoService.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }
}