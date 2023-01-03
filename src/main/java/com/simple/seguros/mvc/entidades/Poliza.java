package com.simple.seguros.mvc.entidades;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import lombok.Data;

@Data
@Entity
public class Poliza {
    @Id
    private String uuid;
    
    @OneToOne
    @JoinColumn(name = "vehiculoId",nullable = false)
    private Vehiculo vehiculo;
    
    private double valor;

    /*
     * Metodo de control para asegurar la existencia de uuid unicas en todos los registros
     */

    @PrePersist
    private void preLoad(){
        if(uuid == null || uuid.length()!= 32){
            this.uuid = UUID.randomUUID().toString().replace("-", "");
        }
    }
    
}