package com.joaquin.restaurante_crud.services.impl;

import com.joaquin.restaurante_crud.dtos.menusDTOs.CreateMenuDTO;
import com.joaquin.restaurante_crud.dtos.menusDTOs.MenuDTO;
import com.joaquin.restaurante_crud.entities.Menu;
import com.joaquin.restaurante_crud.entities.Restaurant;
import com.joaquin.restaurante_crud.mappers.MenuMapper;
import com.joaquin.restaurante_crud.repositories.MenuRepository;
import com.joaquin.restaurante_crud.repositories.RestaurantRepository;
import com.joaquin.restaurante_crud.services.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuServiceImpl(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public MenuDTO createMenu(CreateMenuDTO createMenuDTO) {
        Restaurant restaurant = restaurantRepository.findById(createMenuDTO.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found with id: " + createMenuDTO.getRestaurantId()));

        Menu menu = new Menu();
        menu.setName(createMenuDTO.getName());
        menu.setRestaurant(restaurant);

        menuRepository.save(menu);
        return MenuMapper.toMenuDTO(menu);
    }

    @Override
    public List<MenuDTO> getMenusByRestaurantId(Integer restaurantId) {
        List<Menu> menus = menuRepository.findByRestaurantId(restaurantId);
        return menus.stream().map(MenuMapper::toMenuDTO).collect(Collectors.toList());
    }
}
