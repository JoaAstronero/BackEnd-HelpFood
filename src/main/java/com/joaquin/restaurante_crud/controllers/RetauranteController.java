package com.joaquin.restaurante_crud.controllers;

import com.joaquin.restaurante_crud.dtos.RestauranteDTO;
import com.joaquin.restaurante_crud.services.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/restaurantes")
public class RetauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<RestauranteDTO> createRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        RestauranteDTO creadoRestaurante = restauranteService.save(restauranteDTO);
        return new ResponseEntity<>(creadoRestaurante, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDTO> getRestauranteById(@PathVariable int id) {
        RestauranteDTO restauranteDTO = restauranteService.findById(id);
        return new ResponseEntity<>(restauranteDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> getAllRestaurantes() {
        List<RestauranteDTO> restaurantes = restauranteService.findAll();
        return new ResponseEntity<>(restaurantes, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<RestauranteDTO> deleteRestauranteById(@RequestParam int id) {
        restauranteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
