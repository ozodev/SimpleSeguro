package com.simple.seguros.core.entidades;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
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
    @Column(unique = true)
    private Integer cedula;
    @Column(length = 40,nullable = false)
    private String primerNombre;
    @Column(length = 40,nullable = false)
    private String segundoNombre;
    @Column(length = 40,nullable = false)
    private String primerApellido;
    @Column(length = 40,nullable = false)
    private String segundoApellido;
    @Column(unique = true,nullable = false)
    private Integer telefono;
    private Date creacion;
    private Date actualizacion;
    private boolean habilitado;

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
