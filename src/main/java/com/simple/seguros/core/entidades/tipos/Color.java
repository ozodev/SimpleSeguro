package com.simple.seguros.core.entidades.tipos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.simple.seguros.core.dtos.ColorDto;

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
    private boolean habilitado;

    public Color(){}
    public Color(ColorDto colordto){
        if(Objects.nonNull(colordto.getId())) this.id= colordto.getId();
        this.nombre= colordto.getNombre();
        this.habilitado = colordto.isHabilitado();
    }

    public Color update(Color color){
        this.nombre = color.getNombre();
        this.habilitado = color.isHabilitado();
        return this;
    }
    public Color update(ColorDto color){
        this.nombre = color.getNombre();
        this.habilitado = color.isHabilitado();
        return this;
    }

    @PrePersist
    @PreUpdate
    private void presave(){
        this.nombre = this.nombre.toUpperCase();
    }
}