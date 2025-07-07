package com.example.fincas_grupo3.infrastructure.controllers.descuento;


import com.example.fincas_grupo3.application.dto.descuento.DescuentoRequestDTO;
import com.example.fincas_grupo3.application.dto.descuento.DescuentoResponseDTO;
import com.example.fincas_grupo3.application.dto.descuento.DescuentoRequestDTO;
import com.example.fincas_grupo3.application.dto.descuento.DescuentoResponseDTO;
import com.example.fincas_grupo3.application.services.descuento.DescuentoService;
import com.example.fincas_grupo3.domain.models.descuento.Descuento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController


@RequestMapping("/api/descuentos")
public class DescuentoController {
    private final DescuentoService descuentoService;

    public DescuentoController(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    @PostMapping
    public ResponseEntity<DescuentoResponseDTO> create(@RequestBody DescuentoRequestDTO  dto) {
        DescuentoResponseDTO response = descuentoService.guardar(dto);
        return ResponseEntity.created(URI.create("/api/descuentos/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DescuentoResponseDTO>> findAll() {
        List<DescuentoResponseDTO> response = descuentoService.obtenerTodas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DescuentoResponseDTO> findById(@PathVariable Long id) {
        DescuentoResponseDTO response = descuentoService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<DescuentoResponseDTO> update(@RequestBody DescuentoRequestDTO dto) {
        DescuentoResponseDTO response = descuentoService.actualizar(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        descuentoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
