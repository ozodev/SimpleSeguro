package com.simple.seguros.core.entidades;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Data;

@Data
@Entity
public class Ubicacion {
    
    @Id
    private String uuid;
    @Column(length = 60,nullable = false)
    private String direccion;
    @Column(length = 40,nullable = false)
    private String ciudad;
    @Column(length = 40,nullable = false)
    private String barrio;
    @Column(length = 40,nullable = false)
    private String pais;
    private Date creacion;
    private Date actualizacion;
    private boolean habilitado;

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
