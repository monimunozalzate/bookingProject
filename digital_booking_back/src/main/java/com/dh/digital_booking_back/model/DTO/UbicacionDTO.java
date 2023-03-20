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
public class UbicacionDTO {

    private Long id;

    private String ciudad;

    private String pais;

    private String continente;

    private Set<ProductoDTO> productoDTOSet =new HashSet<>();



}
