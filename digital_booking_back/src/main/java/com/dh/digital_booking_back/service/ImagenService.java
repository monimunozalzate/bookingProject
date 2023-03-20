package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.model.DTO.ImagenDTO;
import com.dh.digital_booking_back.model.DTO.ProductoDTO;
import com.dh.digital_booking_back.model.Imagen;
import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.repository.ImagenRepository;
import com.dh.digital_booking_back.repository.Implementacion.IImagenRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class ImagenService implements IImagenRepository {

    @Autowired
    ImagenRepository imagenRepository;

    @Autowired
    ProductoService productoService;

    public Imagen agregarImagen(Imagen imagen){
        Optional<Producto> productoBuscado = productoService.buscarProductoXId(imagen.getProducto().getId());
        imagen.setProducto(productoBuscado.get());

        return imagenRepository.save(imagen);
    }


    public Optional<Imagen> buscarImagenXId(Long id){
        return imagenRepository.findById(id);
    }

    public List<Imagen> listarImagen(){
        return imagenRepository.findAll();
    }

    public Imagen editarImagen(Imagen imagen) throws BadRequestException{
        Optional<Imagen> imagenBuscada = buscarImagenXId(imagen.getId());
        if (imagenBuscada.isPresent()){
            return imagenRepository.save(imagen);
        }
        else {
            throw new BadRequestException("No se puede actualizar la imagen con id : " + imagen.getId() + " con titutlo : " + imagen.getTitulo() +
                    "Ya que no se encuentran los elementos necesarios para realizar la peticion");
        }

    }


    public void eliminarImagenXId(Long id) throws ResolutionException {
        Optional<Imagen> imagenBuscada = buscarImagenXId(id);
        if (imagenBuscada.isPresent()){
            imagenRepository.deleteById(id);
        }
        else {
            throw new ResolutionException("NO existe la imagen con id " + id + "No se pudo borrar");
        }
    }
}
