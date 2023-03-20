package com.dh.digital_booking_back.model.DTO;


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
public class PoliticaDTO {

    private Long id;

    private String titulo;

    private String descripcion;

    private Set<ProductoDTO> productoDTOSet = new HashSet<>();
}
