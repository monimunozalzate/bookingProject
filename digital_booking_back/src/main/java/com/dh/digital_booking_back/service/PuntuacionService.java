package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.model.Puntuacion;
import com.dh.digital_booking_back.repository.Implementacion.IPuntuacionRepository;
import com.dh.digital_booking_back.repository.PuntuacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuntuacionService implements IPuntuacionRepository {

    @Autowired
    PuntuacionRepository repository;
    @Autowired
    ProductoService productoService;
    //inicializamos nuestros servicios

    //buscar puntuacion por su id
    public Optional<Puntuacion> buscarPuntajeXId(Long id){
        return repository.findById(id);
    }
    //bucar puntuaciones segun el producto
    public Optional <List<Puntuacion>> buscarPuntuacionXProductoId(Long id) {
        return repository.findAllByProductoId(id);
    }
    //agregar puntuacion
    public Puntuacion agregarPuntuacion(Puntuacion puntuacion){
        //seteamos los valores para no pasarle objetos dentro de objetos solo el id
        Optional<Producto> productoBuscado=productoService.buscarProductoXId(puntuacion.getProducto().getId());
        puntuacion.setProducto(productoBuscado.get());
        return repository.save(puntuacion);
    }
    //editar puntuacion(opcional)
    public Puntuacion editarPuntuacion(Puntuacion puntuacion)throws BadRequestException {
        //se le añaden algunas verificaciones para que realmente se pueda modificar (debe tener elementos de un puntaje existente)
        Optional<Puntuacion> puntuacionBuscada = buscarPuntajeXId(puntuacion.getId());
        Optional<Producto> productoBuscado= productoService.buscarProductoXId(puntuacion.getProducto().getId());
        if (productoBuscado.isPresent()&&puntuacionBuscada.isPresent()){
            return repository.save(puntuacion);
        }else{
            throw new BadRequestException("No se puede actualizar la puntuacion con id :"+ puntuacion.getId() +" con valor :" +puntuacion.getValor() +" asociada al producto :" + puntuacion.getProducto().getId()+
                    " no se encontraron los datos necesarios para realizar esta peticion");
        }

    }
}