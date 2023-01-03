package com.simple.seguros.mvc.entidades.tipos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
/*
 * Esta entidad representa los diferentes tipos de combustible que se manejan en los vehiculos
 */
@Data
@Entity
public class Combustible {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 40,unique = true)
    private String nombre;
}
