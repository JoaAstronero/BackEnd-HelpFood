package com.joaquin.restaurante_crud.services;

import com.joaquin.restaurante_crud.dtos.RestauranteDTO;

import java.util.List;

public interface RestauranteService {
    RestauranteDTO save(RestauranteDTO restauranteDTO);
    RestauranteDTO findById(Integer id);
    List<RestauranteDTO> findAll();
    void delete(Integer id);
    RestauranteDTO update(RestauranteDTO restauranteDTO);
}
