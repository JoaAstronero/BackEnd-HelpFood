package com.joaquin.restaurante_crud.controllers;

import com.joaquin.restaurante_crud.dtos.favoritesDTOs.CreateFavoriteDTO;
import com.joaquin.restaurante_crud.dtos.favoritesDTOs.FavoriteDTO;
import com.joaquin.restaurante_crud.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @PostMapping
    public ResponseEntity<FavoriteDTO> createFavorite(@RequestBody CreateFavoriteDTO createFavoriteDTO) {
        FavoriteDTO favoriteDTO = favoriteService.createFavorite(createFavoriteDTO);
        return ResponseEntity.ok(favoriteDTO);
    }

    @DeleteMapping
    public ResponseEntity<FavoriteDTO> deleteFavorite(@RequestBody FavoriteDTO favoriteDTO) {
        favoriteService.removeFavorite(favoriteDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FavoriteDTO>> getFavoriteByUserId(@PathVariable Integer userId) {
        List<FavoriteDTO> favoriteDTOList = favoriteService.getFavoritesByUserId(userId);
        return ResponseEntity.ok(favoriteDTOList);
    }

}
