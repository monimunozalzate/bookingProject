package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Operation(summary = "Traer todos los productos")
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @Operation(summary = "Buscar producto por id")
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoXId(@PathVariable Long id){
        Optional<Producto> buscarProducto = productoService.buscarProductoXId(id);
        return buscarProducto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Crear un nuevo producto")
    @PostMapping
    public ResponseEntity<Producto> editarProducto(@RequestBody Producto producto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.agregarProducto(producto));

    }

    @Operation(summary = "Traer productos que correspondan a una ubicación")
    @GetMapping("/ubicacion/{id}")
    public ResponseEntity <List<Producto>> buscarProductoXCiudad(@PathVariable Long id){
        Optional<List<Producto>> productosBuscados = productoService.listarProductoXUbicacion(id);
        return productosBuscados.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Traer productos que correspondan a una categoria")
    @GetMapping("/categoria/{id}")
    public ResponseEntity <List<Producto>> buscarProductoXCategoria(@PathVariable Long id){
        Optional<List<Producto>> productoBuscado = productoService.listarProductosXCategoria(id);
        return productoBuscado.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Traer listado aleatorio de productos")
    @GetMapping("/rand")
    public ResponseEntity <List<Producto>> listarProductosAleatorio() throws ResourceNotFoundException {
        return ResponseEntity.ok(productoService.listarProductosRand());
    }



}
