package com.joaquin.restaurante_crud.dtos.restaurantsDTOs;

import com.joaquin.restaurante_crud.dtos.menusDTOs.MenuAndDishesDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantWithMenusDTO {
    private Integer id;
    private String name;
    private String description;
    private LocalTime openingHours;
    private LocalTime closingHours;
    private String celNumber;
    private String address;
    private Integer ownerId;
    private List<MenuAndDishesDTO> menus;
}
