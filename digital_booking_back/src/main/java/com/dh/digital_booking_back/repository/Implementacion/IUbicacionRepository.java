package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.UbicacionDTO;
import com.dh.digital_booking_back.model.Ubicacion;

import java.util.List;
import java.util.Optional;

public interface IUbicacionRepository {

    void registrarUbicacion(UbicacionDTO ubicacionDTO);

    Ubicacion registrarUbicacion(Ubicacion ubicacion);

    List<Ubicacion> listarUbicaciones();

    Optional<Ubicacion> buscarUbicacionXId(Long id);

    Ubicacion editarUbicacion(Ubicacion ubicacion)throws BadRequestException;

    void eliminarUbicacionXId(Long id) throws ResourceNotFoundException;
}
