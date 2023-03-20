package com.dh.digital_booking_back.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "puntuaciones")
public class Puntuacion {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY) @NotNull
    private Long id;

    @Column @NotNull
    private double valor;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","nombre","titulo","descripcion","precio","precio","disponible","latitud","longitud","direccion","caracteristicas","politicas","categoria","ubicacion","imagenes","reservas","puntuaciones"})
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_producto",referencedColumnName = "id")
    private Producto producto;



}
