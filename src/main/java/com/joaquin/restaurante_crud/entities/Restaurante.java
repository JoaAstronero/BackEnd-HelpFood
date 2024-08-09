package com.joaquin.restaurante_crud.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurante")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurante_id", nullable = false)
    private Integer id;

    @Column(name = "descripcion", length = Integer.MAX_VALUE)
    private String descripcion;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "num_cel", length = 50)
    private String numCel;

}