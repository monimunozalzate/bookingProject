package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Categoria;
import com.dh.digital_booking_back.model.DTO.CategoriaDTO;

import java.util.List;
import java.util.Optional;

public interface ICategoriaRepository {

    void registrarCategoria(CategoriaDTO categoriaDTO);

    Categoria registrarCategoria(Categoria categoria);

    List<Categoria> listarCategorias();

    Optional<Categoria> buscarCategoriaXId(Long id);

    Categoria editarCategoria(Categoria categoria)throws BadRequestException;

    void eliminarCategoriaXId(Long id) throws ResourceNotFoundException;

}
