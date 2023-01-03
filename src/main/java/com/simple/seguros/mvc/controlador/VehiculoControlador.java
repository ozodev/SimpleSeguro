package com.simple.seguros.mvc.controlador;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.seguros.core.entidades.tipos.Mensajes;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/mvc/vehiculos")
public class VehiculoControlador {

    /*
     * Obtenemos paginacion de vehiculos segun el resultado de la busqueda
     * Obtenemos filtros en los headers de la peticion
     * 
     * @Param headers
     */
    @GetMapping()
    public String getVehiculos(@RequestHeader Map<String, String> headers){
        log.info(Mensajes.Vehiculo.Busqueda.ALL);
        log.info(Mensajes.Varios.LOAD_HEADERS,headers);
        return "Retornamos Listado de vehiculos";
    }

    /*
     * Buscamos existencia de vehiculos por uuid, motor, chasis, placa
     */
    @GetMapping("/{id}")
    public String getVehiculo(@PathVariable String id){
        log.debug(Mensajes.Vehiculo.Busqueda.ID,id);
        return "retornamos informacion de "+id;
    }

    /*
     * Creamos nuevo Vehiculo
     */
    @PostMapping()
    public String createVehiculo(){
        return "Creamos vehiculo";
    }

    /*
     * Actualizamos informacion de Vehiculo
     */
    @PutMapping("/{id}")
    public String updatePersona(@PathVariable String id){
        log.debug(Mensajes.Vehiculo.Busqueda.ID,id);
        return "Actualizamos informacion de vehiculo";
    }

    /*
     * Deshabilitamos vehiculo Vehiculo
     */
    @DeleteMapping("/{id}")
    public String deletePersona(@PathVariable String id){
        log.debug(Mensajes.Vehiculo.Busqueda.ID,id);
        return "eliminamos vehiculo";
    }
    
}