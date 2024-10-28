package com.joaquin.restaurante_crud.controllers;

import com.joaquin.restaurante_crud.dtos.menusDTOs.CreateMenuDTO;
import com.joaquin.restaurante_crud.dtos.menusDTOs.MenuDTO;
import com.joaquin.restaurante_crud.services.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/menus")
public class MenuController {
    private final MenuService menuService;
    public MenuController(final MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<MenuDTO> createMenu(@RequestBody CreateMenuDTO createMenuDTO) {
        MenuDTO menuDTO = menuService.createMenu(createMenuDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(menuDTO);
    }

    @GetMapping("restaurant/{restaurantId}")
    public ResponseEntity<List<MenuDTO>> getMenusByRestaurant(@PathVariable Integer restaurantId) {
        List<MenuDTO> menus = menuService.getMenusByRestaurantId(restaurantId);
        return ResponseEntity.status(HttpStatus.OK).body(menus);
    }
}
