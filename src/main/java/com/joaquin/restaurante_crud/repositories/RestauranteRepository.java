package com.joaquin.restaurante_crud.repositories;

import com.joaquin.restaurante_crud.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
}
