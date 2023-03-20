package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.model.Categoria;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.CategoriaDTO;
import com.dh.digital_booking_back.repository.CategoriaRepository;
import com.dh.digital_booking_back.repository.Implementacion.ICategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaRepository {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ObjectMapper mapper;


    // inicializamos nuestros servicios:

    //agregar categoria

    private void guardarCategoria(CategoriaDTO categoriaDTO){
        Categoria newCategoria = mapper.convertValue(categoriaDTO, Categoria.class);
        categoriaRepository.save(newCategoria);
    }

    public void registrarCategoria(CategoriaDTO categoriaDTO){
        guardarCategoria(categoriaDTO);
    }

    public Categoria registrarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }


    //listar categorias
    public List<Categoria> listarCategorias(){
        return  categoriaRepository.findAll();
    }


    //buscar categoria por su id
    public Optional<Categoria> buscarCategoriaXId(Long id){
        return categoriaRepository.findById(id);
    }

    //editar categoria (opcional)
    public Categoria editarCategoria(Categoria categoria)throws BadRequestException {
        Optional<Categoria> categoriaBuscada = buscarCategoriaXId(categoria.getId());
        if (categoriaBuscada.isPresent()){
            return categoriaRepository.save(categoria);
        }
        else {
            throw new BadRequestException("No se pudo actualizar la categoria con id : "+categoria.getId()+" con nombre : "+categoria.getTitulo()+
                    " con descripcion : "+categoria.getDescripcion()+" con la url : " + categoria.getUrlImagen()+" ya que no se encuentran los elementos necesarios"
                    +"para realizar la peticion. ");
        }

    }
    //eliminar categoria (opcional)
    public void eliminarCategoriaXId(Long id) throws ResourceNotFoundException {
        Optional<Categoria> categoriaBuscada = buscarCategoriaXId(id);
        if (categoriaBuscada.isPresent()){
            categoriaRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No existe la categoria con id : "+id+" no se puede borrar");
        }
    }
}
