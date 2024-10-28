package com.joaquin.restaurante_crud.mappers;

import com.joaquin.restaurante_crud.dtos.menusDTOs.MenuDTO;
import com.joaquin.restaurante_crud.entities.Menu;

public class MenuMapper {
    public static MenuDTO toMenuDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(menu.getId());
        menuDTO.setName(menu.getName());
        menuDTO.setRestaurantId(menu.getRestaurant().getId());
        return menuDTO;
    }
}
