package com.dh.digital_booking_back.repository;

import com.dh.digital_booking_back.model.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PuntuacionRepository extends JpaRepository <Puntuacion,Long> {
    Optional<List<Puntuacion>> findAllByProductoId(Long id);
}
