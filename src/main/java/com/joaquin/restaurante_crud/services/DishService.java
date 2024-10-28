package com.joaquin.restaurante_crud.services;

import com.joaquin.restaurante_crud.dtos.dishesDTOs.CreateDishDTO;
import com.joaquin.restaurante_crud.dtos.dishesDTOs.DishDTO;
import com.joaquin.restaurante_crud.entities.Dish;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface DishService {
    public DishDTO createDish(CreateDishDTO createDishDTO);
    public DishDTO getDishById(Integer id);
    public DishDTO updateDish(Integer id,CreateDishDTO updateDishDTO);
    public void deleteDish(Integer id);
    public List<DishDTO> getDishByMenuId(Integer menuId);
}
