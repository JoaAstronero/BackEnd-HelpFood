package com.joaquin.restaurante_crud.services;

import com.joaquin.restaurante_crud.dtos.menusDTOs.CreateMenuDTO;
import com.joaquin.restaurante_crud.dtos.menusDTOs.MenuDTO;

import java.util.List;

public interface MenuService {
    public MenuDTO createMenu(CreateMenuDTO createMenuDTO);
    public List<MenuDTO> getMenusByRestaurantId(Integer restaurantId);
}
