package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTO;
import com.dh.digital_booking_back.model.Tipolitica;

import java.util.List;
import java.util.Optional;

public interface ITipoliticaReposiory {
    void registrarTipolitica(TipoliticaDTO tipoliticaDTO);
    Tipolitica registrarTipolitica(Tipolitica tipolitica);
    List<Tipolitica> listarTipoliticas();
    Optional<Tipolitica> buscarTipoliticaXId(Long id);
    Tipolitica editarTipolitica(Tipolitica tipolitica) throws BadRequestException;
    void eliminarTipoliticaXId(Long id) throws ResourceNotFoundException;
}