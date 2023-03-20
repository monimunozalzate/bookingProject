package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.model.DTO.PoliticaDTO;
import com.dh.digital_booking_back.model.Politica;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

public interface IPoliticaRepository {

    void registrarCategoria(PoliticaDTO politicaDTO);

    Politica registrarCategoria(Politica politica);

    List<Politica> listarPolitica();

    Optional<Politica> buscarPoliticaXId(Long id);

    Politica editarPolitica(Politica politica)throws BadRequestException;

    void eliminarPoliticaXId(Long id) throws ResolutionException;

    }
