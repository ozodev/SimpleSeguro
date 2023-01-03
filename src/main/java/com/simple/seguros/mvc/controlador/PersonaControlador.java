package com.simple.seguros.mvc.controlador;

import java.util.Map;

import org.springframework.stereotype.Controller;
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
@RequestMapping("/mvc/personas")
public class PersonaControlador {

    /*
     * Obtenemos paginacion de personas segun el resultado de la busqueda
     * Obtenemos filtros en los headers de la peticion
     * 
     * @Param headers
     */
    @GetMapping()
    public String getPersonas(@RequestHeader Map<String, String> headers){
        log.info(Mensajes.Persona.Busqueda.ALL);
        log.info(Mensajes.Varios.LOAD_HEADERS,headers);
        return "Retornamos Listado de personas";
    }

    /*
     * Buscamos existencia de persona por id o cc o telefono
     */
    @GetMapping("/{id}")
    public String getPersona(@PathVariable String id){
        log.debug(Mensajes.Persona.Busqueda.ID,id);
        return "retornamos informacion de "+id;
    }

    @PostMapping()
    public String createPersona(){
        return "Creamos persona";
    }

    @PutMapping("/{id}")
    public String updatePersona(@PathVariable String id){
        log.debug(Mensajes.Persona.Busqueda.ID,id);
        return "Actualizamos informacion de persona";
    }

    @DeleteMapping("/{id}")
    public String deletePersona(@PathVariable String id){
        log.debug(Mensajes.Persona.Busqueda.ID,id);
        return "eliminamos persona";
    }

}