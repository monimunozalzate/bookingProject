package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.model.Puntuacion;

import java.util.List;
import java.util.Optional;

public interface IPuntuacionRepository {

    Optional<Puntuacion> buscarPuntajeXId(Long id);

    Optional <List<Puntuacion>> buscarPuntuacionXProductoId(Long id);

    Puntuacion agregarPuntuacion(Puntuacion puntuacion);

    Puntuacion editarPuntuacion(Puntuacion puntuacion)throws BadRequestException;

}
