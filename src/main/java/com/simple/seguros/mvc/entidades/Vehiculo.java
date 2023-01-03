package com.simple.seguros.mvc.entidades;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import com.simple.seguros.mvc.entidades.tipos.ClaseVehiculo;
import com.simple.seguros.mvc.entidades.tipos.Color;
import com.simple.seguros.mvc.entidades.tipos.Combustible;

import lombok.Data;
/*
 * Esta entidad representa la informacion de los vehiculos registrados
 */
@Data
@Entity
public class Vehiculo {

    @Id
    private String uuid;
    private String placa;
    private String marca;
    private String linea;
    private String motor;
    private String chasis;
    private String servicio;

    private int capacidad;
    private int modelo;
    private double cilindrada;

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
