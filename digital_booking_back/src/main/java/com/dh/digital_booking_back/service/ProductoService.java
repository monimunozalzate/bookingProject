package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.*;
import com.dh.digital_booking_back.model.DTO.CategoriaDTO;
import com.dh.digital_booking_back.model.DTO.ProductoDTO;
import com.dh.digital_booking_back.repository.Implementacion.IProductoRepository;
import com.dh.digital_booking_back.repository.ProductoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductoService implements IProductoRepository {

    @Autowired
    ProductoRepository repository;
    @Autowired
    UbicacionService ubicacionService;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    CaracteristicaService caracteristicaService;
    @Autowired
    PoliticaService politicaService;

    // inicializamos nuestros servicios:

    //agregar producto
    public Producto agregarProducto(Producto producto) {
        //seteamos los valores para no pasarle objetos dentro de objetos solo el id
        Optional<Categoria> categoriaBuscada=categoriaService.buscarCategoriaXId(producto.getCategoria().getId());
        Optional<Ubicacion> ubicacionBuscada=ubicacionService.buscarUbicacionXId(producto.getUbicacion().getId());
        producto.setCategoria(categoriaBuscada.get());
        producto.setUbicacion(ubicacionBuscada.get());
        //inicializamos un array para meterle los valores por id
        Set<Caracteristica> caracteristicas = new HashSet<>();
        for (Caracteristica caracteristica : producto.getCaracteristicas()){
            //buscamos cada id de caracteristicas y lo añadimos al array
            Optional<Caracteristica>caracteristicaBuscada=caracteristicaService.buscarCaracteristicaXId(caracteristica.getId());
            caracteristicas.add(caracteristicaBuscada.get());
        }
        //seteamos que el array de caracteristicas del producto sea igual al que creamos
        producto.setCaracteristicas(caracteristicas);

        //inicializamos un array para meterle los valores por id
        Set<Politica> politicas=new HashSet<>();

        for(Politica politica : producto.getPoliticas()){
            // buscamos cada id de caracteristicas y lo añadimos al array
            Optional<Politica> politicaBuscada = politicaService.buscarPoliticaXId(politica.getId());
            politicas.add(politicaBuscada.get());
        }
        //seteamos que el array de politicas sea igual al que creamos
        producto.setPoliticas(politicas);
        return repository.save(producto);
    }
    //listar productos
    public List<Producto> listarProductos(){
        return  repository.findAll();
    }
    //buscar producto por su id
    public Optional<Producto> buscarProductoXId(Long id){
        return repository.findById(id);
    }

    //buscar producto por su ubicacion
    public Optional<List<Producto>> listarProductoXUbicacion(Long id) {
        return repository.findAllByUbicacionId(id);

    }
    //buscar producto por su categoria
    public Optional <List<Producto>> listarProductosXCategoria(Long id) {
        return repository.findAllByCategoriaId(id);

    }

    public List<Producto> listarProductosRand() throws ResourceNotFoundException{
        Optional<List<Producto>> listaRand = repository.findRandProd();
        if (listaRand.isPresent()) {
            return listaRand.get();
        }else{
            throw new ResourceNotFoundException("No existen productos");
        }
    }

    //editar producto
    public Producto editarProducto(Producto producto) throws BadRequestException {
        //se le añaden algunas verificaciones para que realmente se pueda modificar (debe tener elementos de un producto existente)
        //se le pueden añadir mas segiridad.
        Optional<Producto> productoBuscado=buscarProductoXId(producto.getId());
        Optional<Ubicacion> ubicacionBuscada=ubicacionService.buscarUbicacionXId(producto.getUbicacion().getId());
        Optional<Categoria> categoriaBuscada=categoriaService.buscarCategoriaXId(producto.getCategoria().getId());
        if (productoBuscado.isPresent()&&ubicacionBuscada.isPresent()&&categoriaBuscada.isPresent()){
            return repository.save(producto);
        }else{
            throw new BadRequestException("No se puede actualizar el Producto con el id : " +producto.getId()+
                    " ya que no se encuentran los datos necesarios para realizar la peticion." );
        }

    }

    //eliminar producto (opcional)
    public void eliminarProductoXId(Long id) throws ResourceNotFoundException {
        Optional<Producto> productoBuscado = buscarProductoXId(id);
        if (productoBuscado.isPresent()){
            repository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No existe el producto con id : "+id+" no se puede borrar");
        }

    }
}
