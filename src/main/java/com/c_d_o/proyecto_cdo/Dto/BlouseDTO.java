package com.c_d_o.proyecto_cdo.Dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlouseDTO {
    private String name;
    private Double price;
    private String size;
    private String embroideryType;
    private String fabricType;
}
