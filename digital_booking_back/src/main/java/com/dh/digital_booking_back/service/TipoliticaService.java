package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTO;
import com.dh.digital_booking_back.model.Tipolitica;
import com.dh.digital_booking_back.repository.Implementacion.ITipoliticaReposiory;
import com.dh.digital_booking_back.repository.TipoliticaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoliticaService implements ITipoliticaReposiory {
    @Autowired
    TipoliticaRepository tipoliticaRepository;
    @Autowired
    ObjectMapper mapper;

    private void guardarTipolitica(TipoliticaDTO tipoliticaDTO){
        Tipolitica newTipolitica = mapper.convertValue(tipoliticaDTO, Tipolitica.class);
        tipoliticaRepository.save(newTipolitica);
    }

    public void registrarTipolitica(TipoliticaDTO tipoliticaDTO) {
        guardarTipolitica(tipoliticaDTO);
    }


    public Tipolitica registrarTipolitica(Tipolitica tipolitica) {
        return tipoliticaRepository.save(tipolitica);
    }

    public List<Tipolitica> listarTipoliticas() {
        return tipoliticaRepository.findAll();
    }

    public Optional<Tipolitica> buscarTipoliticaXId(Long id) {
        return tipoliticaRepository.findById(id);
    }

    @Override
    public Tipolitica editarTipolitica(Tipolitica tipolitica) throws BadRequestException {
        Optional<Tipolitica> tipoliticaBuscada = buscarTipoliticaXId(tipolitica.getId());
        if (tipoliticaBuscada.isPresent()){
            return tipoliticaRepository.save(tipolitica);
        }else {
            throw new BadRequestException("No se pudo actualizar el tipo de politica con id : "+tipolitica.getId()+
                    " con nombre : "+tipolitica.getNombre()+
                    " ya que no se encuentran los elementos necesarios para realizar la peticion. ");
        }

    }

    @Override
    public void eliminarTipoliticaXId(Long id) throws ResourceNotFoundException {
        Optional<Tipolitica> tipoliticaBuscada = buscarTipoliticaXId(id);
        if (tipoliticaBuscada.isPresent()){
            tipoliticaRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("No existe el tipo de politica con id : "+id+" no se puede borrar");
        }
    }
}


