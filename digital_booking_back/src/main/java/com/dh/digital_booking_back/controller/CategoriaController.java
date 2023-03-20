package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.model.Categoria;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.CategoriaDTO;
import com.dh.digital_booking_back.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    //metodo get
    @Operation(summary = "Traer todas las categorias")
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @Operation(summary = "Crear una nueva categoria")
    @PostMapping
    public ResponseEntity<?> agregarCategoria(@RequestBody CategoriaDTO categoriaDTO)throws BadRequestException{
        categoriaService.registrarCategoria(categoriaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    //metodo put
    @Operation(summary = "Edita una categoria ")
    @PutMapping
    public ResponseEntity<Categoria> editarCategoria(@RequestBody Categoria categoria) throws ResourceNotFoundException, BadRequestException {
        Categoria categoriaEditada=categoriaService.editarCategoria(categoria);
        return ResponseEntity.ok(categoriaEditada);
    }
    //metodo delete
    @Operation(summary = "Borra a la categoria que especificamos por su id ")
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long id ) throws BadRequestException, ResourceNotFoundException {
        categoriaService.eliminarCategoriaXId(id);
        return ResponseEntity.ok("Categoria con id "+ id+" fue eliminada con exito. ");
    }
}
