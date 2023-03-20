package com.dh.digital_booking_back.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CategoriaDTO {

    private Long id;

    private String titulo;

    private String descripcion;

    private  String urlImagen;

}
