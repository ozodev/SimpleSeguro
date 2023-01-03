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
@RequestMapping("/mvc/polizas")
public class PolizaControlador {

    /*
     * Obtenemos paginacion de polizas segun el resultado de la busqueda
     * Obtenemos filtros en los headers de la peticion
     * 
     * @Param headers
     */
    @GetMapping()
    public String getPolizas(@RequestHeader Map<String, String> headers){
        log.info(Mensajes.Poliza.Busqueda.ALL);
        log.info(Mensajes.Varios.LOAD_HEADERS,headers);
        return "Retornamos Listado de personas";
    }

    /*
     * Buscamos existencia de persona por id o cc o telefono
     */
    @GetMapping("/{id}")
    public String getPoliza(@PathVariable String id){
        log.debug(Mensajes.Poliza.Busqueda.ID,id);
        return "retornamos informacion de "+id;
    }

    @PostMapping()
    public String createPoliza(){
        return "Creamos poliza";
    }

    @PutMapping("/{id}")
    public String updatePoliza(@PathVariable String id){
        log.debug(Mensajes.Poliza.Busqueda.ID,id);
        return "Actualizamos informacion de poliza";
    }

    @DeleteMapping("/{id}")
    public String deletePoliza(@PathVariable String id){
        log.debug(Mensajes.Poliza.Busqueda.ID,id);
        return "eliminamos poliza";
    }
}