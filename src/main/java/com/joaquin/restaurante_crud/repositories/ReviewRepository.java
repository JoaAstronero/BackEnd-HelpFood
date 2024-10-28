package com.joaquin.restaurante_crud.repositories;

import com.joaquin.restaurante_crud.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByRestaurantId(Integer restaurantId);
}
