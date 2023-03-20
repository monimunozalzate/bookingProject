package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.model.Puntuacion;
import com.dh.digital_booking_back.service.PuntuacionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/puntuaciones")
public class PuntuacionController {
    //intanciamos los servicios que le daremos a nuestra api
    @Autowired
    PuntuacionService puntuacionesService;

    //metodo get por producto
    @Operation(summary = "trae una lista de puntuaciones segun el id de su producto")
    @GetMapping("/producto/{id}")
    public ResponseEntity <List<Puntuacion>> buscarPuntuacionXproducto(@PathVariable Long id)  {
        Optional<List<Puntuacion>> puntuacionesBuscadas=puntuacionesService.buscarPuntuacionXProductoId(id);
        return puntuacionesBuscadas.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    //metodo post
    @Operation(summary = "Crear una nueva puntuacion")
    @PostMapping
    public ResponseEntity<Puntuacion> agregarPuntuacion(@RequestBody Puntuacion puntuacion) {
        return ResponseEntity.ok(puntuacionesService.agregarPuntuacion(puntuacion));
    }
    //metodo put
    @Operation(summary = "Edita una puntuacion ")
    @PutMapping
    public ResponseEntity<Puntuacion> editarPuntuacion(@RequestBody Puntuacion puntuacion) throws BadRequestException {
        Puntuacion puntuacionEditada=puntuacionesService.editarPuntuacion(puntuacion);
        return ResponseEntity.ok(puntuacionEditada);
    }

}