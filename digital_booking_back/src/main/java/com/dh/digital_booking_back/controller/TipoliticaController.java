package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTO;
import com.dh.digital_booking_back.model.Tipolitica;
import com.dh.digital_booking_back.service.TipoliticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoliticas")
public class TipoliticaController {
    @Autowired
    TipoliticaService tipoliticaService;

    @Operation(summary = "Traer todos los tipos de politica")
    @GetMapping
    public ResponseEntity<List<Tipolitica>> listarTipoliticas() {
        return ResponseEntity.ok(tipoliticaService.listarTipoliticas());
    }

    @Operation(summary = "Crear un nuevo tipo de politica")
    @PostMapping
    public ResponseEntity<?> agregarTipolitica(@RequestBody TipoliticaDTO tipoliticaDTO) throws BadRequestException{
        tipoliticaService.registrarTipolitica(tipoliticaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Edita un tipo de politica")
    @PutMapping
    public ResponseEntity<Tipolitica> editarTipolitica(@RequestBody Tipolitica tipolitica) throws ResourceNotFoundException, BadRequestException {
        Tipolitica tipoliticaEditada = tipoliticaService.editarTipolitica(tipolitica);
        return ResponseEntity.ok(tipoliticaEditada);
    }

    @Operation(summary = "Borra al tipo de politica especificado por id")
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarTipolitica(@PathVariable Long id) throws ResourceNotFoundException, BadRequestException{
        tipoliticaService.eliminarTipoliticaXId(id);
        return ResponseEntity.ok("Tipo de politica con id "+ id+" fue eliminado con exito. ");
    }
}
