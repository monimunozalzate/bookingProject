package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoRepository {

    Producto agregarProducto(Producto producto);

    List<Producto> listarProductos();

    Optional<Producto> buscarProductoXId(Long id);

    Optional<List<Producto>> listarProductoXUbicacion(Long id);

    Optional <List<Producto>> listarProductosXCategoria(Long id);

    List<Producto> listarProductosRand() throws ResourceNotFoundException;

    Producto editarProducto(Producto producto) throws BadRequestException;

    void eliminarProductoXId(Long id) throws ResourceNotFoundException;

}
