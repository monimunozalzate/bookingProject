package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.model.Imagen;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.service.ImagenService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenController {

    //instanciamos los servicios que le daremos a nuestra api
    @Autowired
    ImagenService imagenService;
    //metodo get
    @Operation(summary = "Traer todas las imagenes")
    @GetMapping
    public ResponseEntity<List<Imagen>> listarImagenes(){
        return ResponseEntity.ok(imagenService.listarImagen());
    }
    //get por id
    @Operation(summary = "Buscar imagen por id")
    @GetMapping("/{id}")
    public ResponseEntity<Imagen> buscarImagen(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Imagen> imagenBuscada = imagenService.buscarImagenXId(id);
        return imagenBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    //metodo post
    @Operation(summary = "Crear una nueva imagen")
    @PostMapping
    public ResponseEntity <Imagen> agregarImagen(@RequestBody Imagen imagen){
        System.out.println("controller " + imagen);
        return ResponseEntity.ok(imagenService.agregarImagen(imagen));
    }
    //metodo put
    @Operation(summary = "Edita una imagen")
    @PutMapping
    public ResponseEntity<Imagen> editarImagen(@RequestBody Imagen imagen) throws BadRequestException {
        Imagen imagenEditada=imagenService.editarImagen(imagen);
        return ResponseEntity.ok(imagenEditada);
    }
    //metodo delete
    @Operation(summary = "Borra a la imagen  que le especificamos por su id ")
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarImagen(@PathVariable Long id ) throws ResourceNotFoundException {
        imagenService.eliminarImagenXId(id);
        return ResponseEntity.ok("Imagen con id "+ id+" fue eliminada con exito. ");
    }
}
