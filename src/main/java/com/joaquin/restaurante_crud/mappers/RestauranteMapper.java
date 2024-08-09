package com.joaquin.restaurante_crud.mappers;

import com.joaquin.restaurante_crud.dtos.RestauranteDTO;
import com.joaquin.restaurante_crud.entities.Restaurante;

public class RestauranteMapper {
    public static RestauranteDTO toDto(Restaurante restaurante) {
        if (restaurante == null) {
            return null;
        }
        RestauranteDTO dto = new RestauranteDTO();
        dto.setId(restaurante.getId());
        dto.setDescripcion(restaurante.getDescripcion());
        dto.setDireccion(restaurante.getDireccion());
        dto.setNumcel(restaurante.getNumCel());
        return dto;
    }

    public static Restaurante toEntity(RestauranteDTO dto) {
        if (dto == null) {
            return null;
        }
        Restaurante restaurante = new Restaurante();
        restaurante.setId(dto.getId());
        restaurante.setDescripcion(dto.getDescripcion());
        restaurante.setDireccion(dto.getDireccion());
        restaurante.setNumCel(dto.getNumcel());
        return restaurante;
    }

}
