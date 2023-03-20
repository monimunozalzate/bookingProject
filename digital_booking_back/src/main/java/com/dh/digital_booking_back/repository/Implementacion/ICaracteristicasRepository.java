package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Caracteristica;
import com.dh.digital_booking_back.model.DTO.CaracteristicaDTO;

import java.util.List;
import java.util.Optional;

public interface ICaracteristicasRepository {

    void registrarCaracteristica(CaracteristicaDTO caracteristicaDTO);

    Caracteristica registrarCaracteristica(Caracteristica caracteristica);

    List<Caracteristica> listarCaracteristicas();

    Optional<Caracteristica> buscarCaracteristicaXId(Long id);

    Caracteristica editarCaracteristica(Caracteristica caracteristica)throws BadRequestException;

    void eliminarCaracteristicaXId(Long id) throws ResourceNotFoundException;

}
