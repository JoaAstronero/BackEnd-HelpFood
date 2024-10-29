package com.joaquin.restaurante_crud.services.impl;

import com.joaquin.restaurante_crud.dtos.favoritesDTOs.CreateFavoriteDTO;
import com.joaquin.restaurante_crud.dtos.favoritesDTOs.FavoriteDTO;
import com.joaquin.restaurante_crud.entities.Favorite;
import com.joaquin.restaurante_crud.entities.Restaurant;
import com.joaquin.restaurante_crud.entities.User;
import com.joaquin.restaurante_crud.mappers.FavoriteMapper;
import com.joaquin.restaurante_crud.repositories.FavoriteRepository;
import com.joaquin.restaurante_crud.repositories.RestaurantRepository;
import com.joaquin.restaurante_crud.repositories.UserRepository;
import com.joaquin.restaurante_crud.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteRepository favoriteRepository;
    private RestaurantRepository restaurantRepository;
    private UserRepository userRepository;

    @Autowired
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.favoriteRepository = favoriteRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public FavoriteDTO createFavorite(CreateFavoriteDTO createFavoriteDTO) {
        User user = userRepository.findById(createFavoriteDTO.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));
        Restaurant restaurant = restaurantRepository.findById(createFavoriteDTO.getRestauranteId())
                .orElseThrow(()-> new RuntimeException("Restaurant not found"));

        if (favoriteRepository.findAllByUserIdAndRestaurantId(user.getId(),restaurant.getId()).isPresent()) {
            throw new RuntimeException("Favorite already exists");
        }

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setRestaurant(restaurant);
        favoriteRepository.save(favorite);

        return FavoriteMapper.toFavoriteDTO(favorite);
    }

    @Override
    public void removeFavorite(FavoriteDTO favoriteDTO) {
        Favorite favorite = favoriteRepository.findAllByUserIdAndRestaurantId(
                favoriteDTO.getUserId(), favoriteDTO.getRestauranteId())
                .orElseThrow(()-> new RuntimeException("Favorite not found"));
        favoriteRepository.delete(favorite);
    }

    @Override
    public List<FavoriteDTO> getFavoritesByUserId(Integer userId) {
        List<Favorite> favorites = favoriteRepository.findAllByUserId(userId);
        return favorites.stream().map(FavoriteMapper::toFavoriteDTO).toList();
    }
}
