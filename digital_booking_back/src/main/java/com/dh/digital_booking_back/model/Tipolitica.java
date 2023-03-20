package com.dh.digital_booking_back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter @Entity @NoArgsConstructor @AllArgsConstructor @Table(name = "tipoliticas")
public class Tipolitica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @NotNull
    @Column(name = "id")
    private Long id;

    @NotNull @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "tipolitica",fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JsonIgnore
    private Set<Politica> politicas = new HashSet<>();

}