package com.joaquin.restaurante_crud.mappers;

import com.joaquin.restaurante_crud.dtos.dishesDTOs.DishDTO;
import com.joaquin.restaurante_crud.entities.Dish;

public class DishMapper {
    public static DishDTO toDishDTO(Dish dish) {
        DishDTO dishDTO = new DishDTO();
        dishDTO.setId(dish.getId());
        dishDTO.setName(dish.getName());
        dishDTO.setDescription(dish.getDescription());
        dishDTO.setPrice(dish.getPrice());
        dishDTO.setMenuId(dish.getMenu().getId());
        return dishDTO;
    }
}
