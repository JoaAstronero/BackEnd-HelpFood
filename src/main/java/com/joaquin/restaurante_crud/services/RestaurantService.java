package com.joaquin.restaurante_crud.services;

import com.joaquin.restaurante_crud.dtos.restaurantsDTOs.CreateRestaurantDTO;
import com.joaquin.restaurante_crud.dtos.restaurantsDTOs.RestaurantDTO;
import com.joaquin.restaurante_crud.dtos.restaurantsDTOs.RestaurantWithMenusDTO;

import java.util.List;

public interface RestaurantService {
    RestaurantDTO createRestaurant(CreateRestaurantDTO createRestaurantDTO);
    RestaurantDTO updateRestaurant(Integer id,RestaurantDTO restaurantDTO);
    RestaurantDTO getRestaurantById(Integer id);
    List<RestaurantDTO> getAllRestaurants();
    boolean deleteRestaurant(Integer id);
    RestaurantWithMenusDTO getRestaurantWithMenusById(Integer id);
    public List<RestaurantDTO> getRestaurantByDishTags(List<Integer> tagsIds);
}
