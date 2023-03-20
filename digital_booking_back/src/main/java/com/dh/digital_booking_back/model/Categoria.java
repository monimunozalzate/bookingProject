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

@Getter @Setter @Entity @NoArgsConstructor @AllArgsConstructor @Table(name = "categorias")
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @NotNull
    @Column(name = "id")
    private Long id;

    @NotNull @Size (min = 1, max = 250)
    @Column(name = "titulo")
    private String titulo;


    @NotNull @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;


    @NotNull @Size (min = 1, max = 250)
    @Column(name = "url_imagen")
    private  String urlImagen;

    @OneToMany(mappedBy = "categoria",fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JsonIgnore
    private Set<Producto> productos=new HashSet<>();


}
