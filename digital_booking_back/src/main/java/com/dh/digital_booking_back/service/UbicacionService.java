package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.model.DTO.PoliticaDTO;
import com.dh.digital_booking_back.model.DTO.UbicacionDTO;
import com.dh.digital_booking_back.model.Politica;
import com.dh.digital_booking_back.model.Ubicacion;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.repository.Implementacion.IUbicacionRepository;
import com.dh.digital_booking_back.repository.UbicacionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService implements IUbicacionRepository {

    @Autowired
    UbicacionRepository repository;

    @Autowired
    ObjectMapper mapper;
    //inicializamos nuestros servicios

    //agregar ubicacion
    private Ubicacion guardarUbicacion(UbicacionDTO ubicacionDTO){

        Ubicacion newUbicacion =  mapper.convertValue(ubicacionDTO, Ubicacion.class);

        return repository.save(newUbicacion);
    }



    public void registrarUbicacion(UbicacionDTO ubicacionDTO){
        guardarUbicacion(ubicacionDTO);
    }


    public Ubicacion registrarUbicacion(Ubicacion ubicacion){
        return repository.save(ubicacion);
    }

    //listar ubicaciones
    public List<Ubicacion> listarUbicaciones(){
        return  repository.findAll();
    }
    //buscar ubicaciones
    public Optional<Ubicacion> buscarUbicacionXId(Long id){
        return repository.findById(id);
    }
    //editar ubicacion
    public Ubicacion editarUbicacion(Ubicacion ubicacion)throws BadRequestException {
        Optional<Ubicacion> ubicacionBuscada = buscarUbicacionXId(ubicacion.getId());
        if (ubicacionBuscada.isPresent()){
            return repository.save(ubicacion);
        }
        else {
            throw new BadRequestException("No se pudo actualizar la ubicacion con id : "+ ubicacion.getId()+" con nombre: "+ ubicacion.getCiudad()+
                    " con pais : "+ ubicacion.getPais()+" con el continente  : " + ubicacion.getContinente()+" ya que no se encuentran los elementos necesarios"
                    +"para realizar la peticion. ");
        }

    }
    //eliminar ubicacion(opcional)
    public void eliminarUbicacionXId(Long id) throws ResourceNotFoundException {
        Optional<Ubicacion> ubicacionBuscada = buscarUbicacionXId(id);
        if (ubicacionBuscada.isPresent()){
            repository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No existe la ubicacion con id : "+id+" no se puede borrar");
        }

    }
}

