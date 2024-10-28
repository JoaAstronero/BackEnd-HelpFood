package com.joaquin.restaurante_crud.repositories;

import com.joaquin.restaurante_crud.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findDishByMenuId(Integer menuId);
}
