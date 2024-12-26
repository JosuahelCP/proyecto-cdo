package com.c_d_o.proyecto_cdo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "blusas")
public class Blouse{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "precio")
    private Double price;
    @Column(name = "talla")
    private String size;
    @Column(name = "tipo_de_bordado")
    private String embroideryType;
    @Column(name = "tipo_de_tela")
    private String fabricType;
    @Column(name = "imagenes")
    private List<String> images;
}
