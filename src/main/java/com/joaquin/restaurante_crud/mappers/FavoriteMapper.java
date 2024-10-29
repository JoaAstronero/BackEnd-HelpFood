package com.joaquin.restaurante_crud.mappers;

import com.joaquin.restaurante_crud.dtos.favoritesDTOs.FavoriteDTO;
import com.joaquin.restaurante_crud.entities.Favorite;

public class FavoriteMapper {
    public static FavoriteDTO toFavoriteDTO(Favorite favorite) {
        FavoriteDTO favoriteDTO = new FavoriteDTO();
        favoriteDTO.setId(favorite.getId());
        favoriteDTO.setUserId(favoriteDTO.getUserId());
        favoriteDTO.setRestauranteId(favoriteDTO.getRestauranteId());

        return favoriteDTO;
    }
}
