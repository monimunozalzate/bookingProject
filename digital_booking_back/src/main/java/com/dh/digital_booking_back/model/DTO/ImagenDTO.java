package com.dh.digital_booking_back.model.DTO;

import com.dh.digital_booking_back.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImagenDTO {

    private Long id;

    private String titulo;

    private String urlImg;

    private ProductoDTO productoDTO;

}
