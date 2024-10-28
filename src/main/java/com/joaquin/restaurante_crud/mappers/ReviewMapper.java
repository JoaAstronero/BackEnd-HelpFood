package com.joaquin.restaurante_crud.mappers;

import com.joaquin.restaurante_crud.dtos.restaurantsDTOs.RestaurantDTO;
import com.joaquin.restaurante_crud.dtos.reviewsDTOs.ReviewDTO;
import com.joaquin.restaurante_crud.dtos.userDTOs.UserDTO;
import com.joaquin.restaurante_crud.entities.Review;

public class ReviewMapper {
    public static ReviewDTO toReviewDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setRating(review.getRating());

        UserDTO userDTO = UserMapper.toUserDto(review.getUser());
        reviewDTO.setUser(userDTO);
        RestaurantDTO restaurantDTO = RestaurantMapper.toRestaurantDTO(review.getRestaurant());
        reviewDTO.setRestaurant(restaurantDTO);

        return reviewDTO;
    }
}
