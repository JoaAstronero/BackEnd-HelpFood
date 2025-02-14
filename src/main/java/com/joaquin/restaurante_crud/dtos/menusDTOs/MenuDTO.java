package com.joaquin.restaurante_crud.dtos.menusDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private Integer id;
    private String name;
    private Integer restaurantId;
}
