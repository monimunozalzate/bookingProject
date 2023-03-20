package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.model.Imagen;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

public interface IImagenRepository {

    Imagen agregarImagen(Imagen imagen);

    Optional<Imagen> buscarImagenXId(Long id);

    List<Imagen> listarImagen();

    Imagen editarImagen(Imagen imagen) throws BadRequestException;

    void eliminarImagenXId(Long id) throws ResolutionException;


}
