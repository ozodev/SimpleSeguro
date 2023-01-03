package com.simple.seguros.mvc.entidades.tipos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
/*
 * Esta clase representa las categorias de vehiculos que se an registrado en el sistema
 */
@Data
@Entity
public class ClaseVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false,length = 40,unique = true)
    private String nombre;
}
