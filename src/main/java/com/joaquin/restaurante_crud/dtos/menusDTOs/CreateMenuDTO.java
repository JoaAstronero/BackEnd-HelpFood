package com.joaquin.restaurante_crud.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMenuDTO {
    private String menuName;
    private Long restaurantId
}
