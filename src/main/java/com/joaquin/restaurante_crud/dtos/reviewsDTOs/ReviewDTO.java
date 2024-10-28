package com.joaquin.restaurante_crud.dtos.reviewsDTOs;

import com.joaquin.restaurante_crud.dtos.restaurantsDTOs.RestaurantDTO;
import com.joaquin.restaurante_crud.dtos.userDTOs.UserDTO;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Integer id;
    private UserDTO user;
    private RestaurantDTO restaurant;
    private int rating;
    private String comment;
}
