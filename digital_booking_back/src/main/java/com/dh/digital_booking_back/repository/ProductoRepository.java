package com.dh.digital_booking_back.repository;

import com.dh.digital_booking_back.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<List<Producto>> findAllByCategoriaId(Long id);

    Optional<List<Producto>> findAllByUbicacionId(Long id);

    @Query(value = "SELECT * FROM PRODUCTOS p ORDER BY RAND() LIMIT 8", nativeQuery = true)
    Optional<List<Producto>> findRandProd();

}
