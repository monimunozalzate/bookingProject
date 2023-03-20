package com.dh.digital_booking_back.model.DTO;


import com.dh.digital_booking_back.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Long id;

    private String nombre;

    private String titulo;

    private String descripcion;

    private double precio;

    private boolean disponible;

    private Set<CaracteristicaDTO> caracteristicaDTOSet = new HashSet<>();

    private Set<PoliticaDTO> politicaDTOHashSet = new HashSet<>();

    private CategoriaDTO categoriaDTO;

    private UbicacionDTO ubicacionDTO;

    private Set<ImagenDTO> imagenesDtoSet = new HashSet<>();

}
