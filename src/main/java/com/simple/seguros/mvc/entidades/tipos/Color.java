package com.simple.seguros.mvc.entidades.tipos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
/*
 * Esta entidad representa todos los colores registrados para vehiculos
 */
@Entity
@Data
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false,length = 40,unique = true)
    private String nombre;
}