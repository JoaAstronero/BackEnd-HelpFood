package com.joaquin.restaurante_crud.services;

import com.joaquin.restaurante_crud.dtos.favoritesDTOs.CreateFavoriteDTO;
import com.joaquin.restaurante_crud.dtos.favoritesDTOs.FavoriteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoriteService {
    public FavoriteDTO createFavorite(CreateFavoriteDTO createFavoriteDTO);
    public void removeFavorite(FavoriteDTO favoriteDTO);
    public List<FavoriteDTO> getFavoritesByUserId(Integer userId);
}
