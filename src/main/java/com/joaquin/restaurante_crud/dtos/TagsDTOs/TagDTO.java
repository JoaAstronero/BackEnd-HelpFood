package com.joaquin.restaurante_crud.dtos.TagsDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDTO {
    private int id;
    private String name;
}
