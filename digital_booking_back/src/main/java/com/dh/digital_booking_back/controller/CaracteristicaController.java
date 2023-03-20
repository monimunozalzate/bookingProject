package com.dh.digital_booking_back.controller;


import com.dh.digital_booking_back.model.Caracteristica;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.CaracteristicaDTO;
import com.dh.digital_booking_back.service.CaracteristicaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/caracteristicas")
public class CaracteristicaController {

    @Autowired
    CaracteristicaService caracteristicaService;

    //metodo get
    @Operation(summary = "Traer todas las caracteristicas")
    @GetMapping
    public ResponseEntity<List<Caracteristica>> listarCaracteristicas(){
        return ResponseEntity.ok(caracteristicaService.listarCaracteristicas());
    }
    //get por id
    @Operation(summary = "Buscar caracteristica por id")
    @GetMapping("/{id}")
    public ResponseEntity<Caracteristica> buscarCaracteristica(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Caracteristica> caracteristicaBuscada = caracteristicaService.buscarCaracteristicaXId(id);
        return caracteristicaBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    //metodo post
    @Operation(summary = "Crear una nueva caracteristica")
    @PostMapping
    public ResponseEntity <?> agregarCaracteristica(@RequestBody CaracteristicaDTO caracteristicaDTO)throws BadRequestException{
        caracteristicaService.registrarCaracteristica(caracteristicaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    //metodo put
    @Operation(summary = "Edita una caracteristica ")
    @PutMapping
    public ResponseEntity<Caracteristica> editarCaracteristica(@RequestBody Caracteristica caracteristica) throws BadRequestException {
        Caracteristica caracteristicaEditada=caracteristicaService.editarCaracteristica(caracteristica);
        return ResponseEntity.ok(caracteristicaEditada);
    }
    //metodo delete
    @Operation(summary = "Borra a la caracteristica que especificamos por su id ")
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarCaracteristica(@PathVariable Long id ) throws ResourceNotFoundException {
        caracteristicaService.eliminarCaracteristicaXId(id);
        return ResponseEntity.ok("Caracteristica con id "+ id+" fue eliminada con exito. ");
    }

}
