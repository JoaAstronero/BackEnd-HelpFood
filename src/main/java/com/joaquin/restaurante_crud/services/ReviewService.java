package com.joaquin.restaurante_crud.services;

import com.joaquin.restaurante_crud.dtos.reviewsDTOs.CreateReviewDTO;
import com.joaquin.restaurante_crud.dtos.reviewsDTOs.ReviewDTO;
import com.joaquin.restaurante_crud.entities.Review;

import java.util.List;

public interface ReviewService {
    public ReviewDTO createReview(CreateReviewDTO createReviewDTO);
    public ReviewDTO updateReview(ReviewDTO reviewDTO);
    public List<ReviewDTO> getReviewsByRestaurant(Integer restaurantId);
    public void deleteReview(Integer reviewId);
}
