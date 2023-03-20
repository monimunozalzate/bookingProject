package com.dh.digital_booking_back.model.DTO;

import com.dh.digital_booking_back.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter  @AllArgsConstructor @NoArgsConstructor
public class CaracteristicaDTO {

    private Long id;

    private String nombre;

    private Set<ProductoDTO> productoDTOSet = new HashSet<>();


}
