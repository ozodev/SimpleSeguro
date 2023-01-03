package com.simple.seguros.mvc.entidades;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Data;

@Data
@Entity
public class Ubicacion {
    
    @Id
    private String uuid;
    private String direccion;
    private String ciudad;
    private String barrio;
    private String pais;

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
