package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.model.DTO.PoliticaDTO;
import com.dh.digital_booking_back.model.Politica;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.repository.Implementacion.IPoliticaRepository;
import com.dh.digital_booking_back.repository.PoliticaRepository;
import com.dh.digital_booking_back.repository.ProductoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class PoliticaService implements IPoliticaRepository {

    @Autowired
    PoliticaRepository politicaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    ObjectMapper mapper;



    private void guardarPolitica(PoliticaDTO politicaDTO){
        Politica newPolitica = mapper.convertValue(politicaDTO, Politica.class);
        politicaRepository.save(newPolitica);
    }

    public void registrarCategoria(PoliticaDTO politicaDTO){
        guardarPolitica(politicaDTO);
    }


    public Politica registrarCategoria(Politica politica){
        return politicaRepository.save(politica);
    }

    public List<Politica> listarPolitica(){
        return politicaRepository.findAll();
    }

    public Optional<Politica> buscarPoliticaXId(Long id){
        return politicaRepository.findById(id);
    }

    public Politica editarPolitica(Politica politica)throws BadRequestException{
        Optional<Politica> politicaBuscada = buscarPoliticaXId(politica.getId());
        if (politicaBuscada.isPresent()){
            return politicaRepository.save(politica);
        }
        else {
            throw new BadRequestException("No se puede actualizar la politica con id" + politica.getId() + " con titulo " + politica.getTitulo() +
                    "Ya que no se encuentran los elementos necesarios para realizar la peticion ");
        }
    }

    public void eliminarPoliticaXId(Long id) throws ResolutionException {
        Optional<Politica> politicaBuscada = buscarPoliticaXId(id);
        if (politicaBuscada.isPresent()){
            politicaRepository.deleteById(id);
        } else {
            throw new ResolutionException("No existe la politica con id : " + id + "No se puede borrar");
        }
    }

}


