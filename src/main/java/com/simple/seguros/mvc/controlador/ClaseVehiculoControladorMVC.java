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

import com.simple.seguros.core.Mensajes;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/mvc/clasevehiculo")
public class ClaseVehiculoControladorMVC {

    /*
     * Obtenemos paginacion de las clases de vehiculo segun el resultado de la busqueda
     * Obtenemos filtros en los headers de la peticion
     * 
     * @Param headers
     */
    @GetMapping()
    public String getClaseVehiculos(@RequestHeader Map<String, String> headers){
        log.info(Mensajes.ClaseVehiculo.Busqueda.ALL);
        log.info(Mensajes.Varios.LOAD_HEADERS,headers);
        return "Retornamos Listado de clase vehiculo";
    }

    /*
     * Buscamos existencia de persona por id o cc o telefono
     */
    @GetMapping("/{id}")
    public String getClaseVehiculo(@PathVariable String id){
        log.debug(Mensajes.ClaseVehiculo.Busqueda.ID,id);
        return "retornamos informacion de "+id;
    }

    @PostMapping()
    public String createClaseVehiculo(){
        return "Creamos clase vehiculo";
    }

    @PutMapping()
    public String updateClaseVehiculo(){
        log.debug(Mensajes.ClaseVehiculo.Busqueda.ALL);
        return "Actualizamos informacion de clase vehiculo";
    }

    @DeleteMapping()
    public String deleteClaseVehiculo(){
        log.debug(Mensajes.ClaseVehiculo.Busqueda.ALL);
        return "eliminamos clase vehiculo";
    }

}