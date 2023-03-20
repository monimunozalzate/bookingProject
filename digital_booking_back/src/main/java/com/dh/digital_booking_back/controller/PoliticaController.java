package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.model.DTO.PoliticaDTO;
import com.dh.digital_booking_back.model.Politica;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.service.PoliticaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/politicas")
public class PoliticaController {

    @Autowired
    PoliticaService politicaService;
    //metodo get
    @Operation(summary = "Traer todas las politicass")
    @GetMapping
    public ResponseEntity<List<Politica>> listarPoliticas(){
        return ResponseEntity.ok(politicaService.listarPolitica());
    }
    //get por id
    @Operation(summary = "Buscar politica por id")
    @GetMapping("/{id}")
    public ResponseEntity<Politica> buscarPolitica(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Politica> politicaBuscada = politicaService.buscarPoliticaXId(id);
        return politicaBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    //metodo post
    @Operation(summary = "Crear una nueva politica")
    @PostMapping
    public ResponseEntity<?> agregarPolitica(@RequestBody PoliticaDTO politicaDTO){
        politicaService.registrarCategoria(politicaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    //metodo put
    @Operation(summary = "Edita una politica ")
    @PutMapping
    public ResponseEntity<Politica> editarPolitica(@RequestBody Politica politica) throws BadRequestException {
        Politica politicaeditada=politicaService.editarPolitica(politica);
        return ResponseEntity.ok(politicaeditada);
    }
    //metodo delete
    @Operation(summary = "Borra a la politica que especificamos por su id ")
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPolitica(@PathVariable Long id ) throws ResourceNotFoundException {
        politicaService.eliminarPoliticaXId(id);
        return ResponseEntity.ok("Politica con id "+ id+" fue eliminada con exito. ");
    }

}
