package com.simple.seguros.mvc.entidades;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import lombok.Data;
/*
 * Esta entidad representa la informacion personal de una persona
 */
@Data
@Entity
public class Persona {

    @Id
    private String uuid;
    private Integer cedula;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer telefono;

    @OneToOne
    @JoinColumn(name = "ubicacionId",nullable = false)
    private Ubicacion ubicacion;

    @OneToMany
    private Set<Vehiculo> vehiculos;

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
