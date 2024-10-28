package com.joaquin.restaurante_crud.repositories;

import com.joaquin.restaurante_crud.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findByRestaurantId(Integer restaurantId);
}
