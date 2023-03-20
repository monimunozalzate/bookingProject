package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.model.Caracteristica;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Categoria;
import com.dh.digital_booking_back.model.DTO.CaracteristicaDTO;
import com.dh.digital_booking_back.model.DTO.CategoriaDTO;
import com.dh.digital_booking_back.repository.CaracteristicaRepository;
import com.dh.digital_booking_back.repository.Implementacion.ICaracteristicasRepository;
import com.dh.digital_booking_back.repository.Implementacion.ICategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaService implements ICaracteristicasRepository {

    @Autowired
    CaracteristicaRepository caracteristicaRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarCaracteristica(CaracteristicaDTO  caracteristicaDTO){
        Caracteristica newCaracteristica = mapper.convertValue(caracteristicaDTO, Caracteristica.class);
        caracteristicaRepository.save(newCaracteristica);
    }

    public void registrarCaracteristica(CaracteristicaDTO caracteristicaDTO){
        guardarCaracteristica(caracteristicaDTO);
    }

    //agregar caracteristica
    public Caracteristica registrarCaracteristica(Caracteristica caracteristica) {
        return caracteristicaRepository.save(caracteristica);
    }

    //listar caracteristicas
    public List<Caracteristica> listarCaracteristicas() {
        return caracteristicaRepository.findAll();
    }

    //buscar Caracteristica por su id
    public Optional<Caracteristica> buscarCaracteristicaXId(Long id) {
        return caracteristicaRepository.findById(id);
    }

    //editar caracteristica
    public Caracteristica editarCaracteristica(Caracteristica caracteristica) throws BadRequestException {
        Optional<Caracteristica> caracteristicaBuscada = buscarCaracteristicaXId(caracteristica.getId());
        if (caracteristicaBuscada.isPresent()) {
            return caracteristicaRepository.save(caracteristica);
        } else {
            throw new BadRequestException("No se pudo actualizar la caracteristica con id: " + caracteristica.getId() + " con nombre: " + caracteristica.getNombre() +
                    "ya que no se encuentran los datos necesarios para realizar la peticion. ");
        }

    }

    //eliminar Caracteristica
    public void eliminarCaracteristicaXId(Long id) throws ResourceNotFoundException {
        Optional<Caracteristica> caracteristicaBuscada = buscarCaracteristicaXId(id);
        if (caracteristicaBuscada.isPresent()) {
            caracteristicaRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("No existe la caracteristica con id : " + id + " no se puede borrar");
        }

    }
}
