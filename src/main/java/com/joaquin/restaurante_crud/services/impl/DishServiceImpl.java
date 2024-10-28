package com.joaquin.restaurante_crud.services.impl;

import com.joaquin.restaurante_crud.dtos.dishesDTOs.CreateDishDTO;
import com.joaquin.restaurante_crud.dtos.dishesDTOs.DishDTO;
import com.joaquin.restaurante_crud.entities.Dish;
import com.joaquin.restaurante_crud.entities.Menu;
import com.joaquin.restaurante_crud.entities.Tag;
import com.joaquin.restaurante_crud.mappers.DishMapper;
import com.joaquin.restaurante_crud.repositories.DishRepository;
import com.joaquin.restaurante_crud.repositories.MenuRepository;
import com.joaquin.restaurante_crud.repositories.TagRepository;
import com.joaquin.restaurante_crud.services.DishService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {

    private final MenuRepository menuRepository;
    private final DishRepository dishRepository;
    private final TagRepository tagRepository;

    public DishServiceImpl(MenuRepository menuRepository, DishRepository dishRepository, TagRepository tagRepository) {
        this.menuRepository = menuRepository;
        this.dishRepository = dishRepository;
        this.tagRepository = tagRepository;
    }
    @Override
    public DishDTO createDish(CreateDishDTO createDishDTO) {
        Menu menu = menuRepository.findById(createDishDTO.getMenuId())
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        Dish dish = new Dish();
        dish.setName(createDishDTO.getName());
        dish.setDescription(createDishDTO.getDescription());
        dish.setPrice(createDishDTO.getPrice());
        dish.setMenu(menu);

        List<Tag> tags = tagRepository.findAllById(createDishDTO.getTagsId());
        dish.setTags(new HashSet<>(tags));

        dishRepository.save(dish);
        return DishMapper.toDishDTO(dish);
    }

    @Override
    public DishDTO getDishById(Integer id) {
        Dish dish = dishRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Dish not found")
        );
        return DishMapper.toDishDTO(dish);
    }

    @Override
    public DishDTO updateDish(Integer id, CreateDishDTO updateDishDTO) {
        Dish updatedDish = dishRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Dish not found")
        );
        if(updateDishDTO.getMenuId() != null) {
            Menu menu = menuRepository.findById(updateDishDTO.getMenuId()).orElseThrow(
                    () -> new RuntimeException("Menu not found")
            );
            updatedDish.setMenu(menu);
        }
        updatedDish.setName(updateDishDTO.getName());
        updatedDish.setDescription(updateDishDTO.getDescription());
        updatedDish.setPrice(updateDishDTO.getPrice());

        dishRepository.save(updatedDish);
        return DishMapper.toDishDTO(updatedDish);
    }

    @Override
    public void deleteDish(Integer id) {
        dishRepository.deleteById(id);
    }

    @Override
    public List<DishDTO> getDishByMenuId(Integer menuId) {
        return dishRepository.findDishByMenuId(menuId)
                .stream()
                .map(DishMapper::toDishDTO)
                .toList();
    }
}
