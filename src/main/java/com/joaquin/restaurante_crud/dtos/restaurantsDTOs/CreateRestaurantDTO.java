package com.joaquin.restaurante_crud.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRestaurantDTO {
    private String name;
    private String description;
    private LocalTime openingHours;
    private LocalTime closingHours;
    private String celNumber;
    private String address;
    private int ownerId;
}
