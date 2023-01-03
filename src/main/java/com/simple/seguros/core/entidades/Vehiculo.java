package com.simple.seguros.core.entidades;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import com.simple.seguros.core.entidades.tipos.ClaseVehiculo;
import com.simple.seguros.core.entidades.tipos.Color;
import com.simple.seguros.core.entidades.tipos.Combustible;
import com.simple.seguros.core.entidades.tipos.ServicioType;

import lombok.Data;
/*
 * Esta entidad representa la informacion de los vehiculos registrados
 */
@Data
@Entity
public class Vehiculo {

    @Id
    private String uuid;
    @Column(length = 6,nullable = false,unique = true)
    private String placa;
    @Column(length = 20,nullable = false)
    private String marca;
    @Column(length = 20,nullable = false)
    private String linea;
    @Column(length = 40,nullable = false,unique = true)
    private String motor;
    @Column(length = 40,nullable = false,unique = true)
    private String chasis;
    @Column(nullable = false)
    private ServicioType servicio;

    private int capacidad;
    private int modelo;
    private double cilindrada;
    private Date creacion;
    private Date actualizacion;
    private boolean habilitado;

    @ManyToOne
    @JoinColumn(name = "colorId",nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "claseVehiculoId",nullable = false)
    private ClaseVehiculo clase;

    @ManyToOne
    @JoinColumn(name = "combustibleId",nullable = false)
    private Combustible combustible;
    

    @ManyToOne
    private Persona persona;

    @OneToOne
    private Poliza poliza;

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
