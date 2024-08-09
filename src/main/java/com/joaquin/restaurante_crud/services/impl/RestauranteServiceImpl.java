package com.joaquin.restaurante_crud.services.impl;

import com.joaquin.restaurante_crud.dtos.RestauranteDTO;
import com.joaquin.restaurante_crud.entities.Restaurante;
import com.joaquin.restaurante_crud.repositories.RestauranteRepository;
import com.joaquin.restaurante_crud.services.RestauranteService;
import com.joaquin.restaurante_crud.mappers.RestauranteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public RestauranteDTO save(RestauranteDTO restauranteDTO) {
        Restaurante restaurante = RestauranteMapper.toEntity(restauranteDTO);
        restaurante = restauranteRepository.save(restaurante);
        return RestauranteMapper.toDto(restaurante);
    }

    @Override
    public RestauranteDTO findById(Integer id) {
        Restaurante restaurante = restauranteRepository.findById(id).orElse(null);
        return null;
    }

    @Override
    public List<RestauranteDTO> findAll() {
        return restauranteRepository.findAll().stream()
                .map(RestauranteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        restauranteRepository.deleteById(id);
    }

    @Override
    public RestauranteDTO update(RestauranteDTO restauranteDTO) {
        Restaurante restaurante = restauranteRepository.findById(restauranteDTO.getId()).orElse(null);
        return RestauranteMapper.toDto(restaurante);

    }
}
