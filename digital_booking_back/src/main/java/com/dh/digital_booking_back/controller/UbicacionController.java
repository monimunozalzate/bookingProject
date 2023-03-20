package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.model.DTO.UbicacionDTO;
import com.dh.digital_booking_back.model.Ubicacion;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.service.UbicacionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {

    //instanciamos los servicios que le daremos a nuestra api
    @Autowired
    UbicacionService ubicacionService;

    //metodo get
    @Operation(summary = "Traer todas las ubicaciones")
    @GetMapping()
    public ResponseEntity<List<Ubicacion>> listarUbicaciones() {
        return ResponseEntity.ok(ubicacionService.listarUbicaciones());
    }

    //get por id
    @Operation(summary = "Buscar ubicacion por id")
    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion> buscarUbicacion(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Ubicacion> ubicacionBuscada = ubicacionService.buscarUbicacionXId(id);
        return ubicacionBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    //metodo post
    @Operation(summary = "Crear una nueva ubicacion")
    @PostMapping
    public ResponseEntity<?> agregarUbicacion(@RequestBody UbicacionDTO ubicacionDTO) {
        ubicacionService.registrarUbicacion(ubicacionDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //metodo put
    @Operation(summary = "Edita una ubicacion ")
    @PutMapping
    public ResponseEntity<Ubicacion> editarUbicacion(@RequestBody Ubicacion ubicacion) throws BadRequestException {
        Ubicacion ubicacionEditada = ubicacionService.editarUbicacion(ubicacion);
        return ResponseEntity.ok(ubicacionEditada);
    }

    //metodo delete
    @Operation(summary = "Borra a la ubicacion que especificamos por su id ")
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarUbicacion(@PathVariable Long id) throws ResourceNotFoundException {
        ubicacionService.eliminarUbicacionXId(id);
        return ResponseEntity.ok("Ubicacion con id " + id + " fue eliminada con exito. ");
    }

}
