package com.joaquin.restaurante_crud.dtos.rerviewsDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Integer userId;
    private Integer restaurantId;
    private int rating;
    private String comment;
}
