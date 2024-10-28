package com.joaquin.restaurante_crud.dtos.menusDTOs;

import com.joaquin.restaurante_crud.dtos.dishesDTOs.DishDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuAndDishesDTO {
    private Integer id;
    private String name;
    private List<DishDTO> dishes;
}
