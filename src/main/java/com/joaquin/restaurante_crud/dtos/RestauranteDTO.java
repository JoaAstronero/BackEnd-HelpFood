package com.joaquin.restaurante_crud.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteDTO {
    private int id;
    private String descripcion;
    private String direccion;
    private String numcel;
}
