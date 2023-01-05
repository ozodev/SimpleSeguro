package com.simple.seguros.mvc.controlador;

import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simple.seguros.core.Mensajes;
import com.simple.seguros.core.dtos.ColorDto;
import com.simple.seguros.core.dtos.PageDto;
import com.simple.seguros.core.dtos.ResponseDto;
import com.simple.seguros.core.entidades.tipos.Color;
import com.simple.seguros.mvc.servicios.ColorServicio;
import com.simple.seguros.mvc.servicios.MensajeService;
import com.simple.seguros.mvc.vistas.ColorView;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/mvc/colores")
public class ColorControladorMVC{

    @Autowired
    private ColorServicio colorServicio;

    @Autowired
    private ColorView colorView;

    @Autowired
    private MensajeService mensajeService;

    /*
     * Obtenemos paginacion de colores segun el resultado de la busqueda
     * Obtenemos filtros en los headers de la peticion
     * 
     * @Param headers
     */
    @GetMapping()
    public @ResponseBody ResponseEntity<ResponseDto> getColores(@RequestHeader Map<String, String> headers){
        log.info(Mensajes.Color.Busqueda.ALL);
        log.info(Mensajes.Varios.LOAD_HEADERS,headers);
        //TODO implementar busqueda personalizada por headers
        Page<Color> resultado = colorServicio.getColores();
        log.info(Mensajes.Color.Busqueda.COMPLETE, resultado);
        PageDto respuesta = colorView.getColorPageDto(resultado);
        log.info(Mensajes.Varios.RESPONSE, respuesta);
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    /*
     * Buscamos existencia de colores por id y nombre
     */
    @GetMapping("/{id}")
    public  @ResponseBody ResponseEntity<ResponseDto> getColor(@PathVariable String id,HttpServletRequest request){
        int ide;
        try {
            ide = Integer.parseInt(id);
        } catch (Exception e) {
            return mensajeService.entityNotFound(id, request.getRequestURI());
        }
        log.info(Mensajes.Color.Busqueda.ID,ide);
        Color color = colorServicio.getColor(ide);
        if(Objects.isNull(color))
            return mensajeService.entityNotFound(id, request.getRequestURI());
        log.info(Mensajes.Color.Busqueda.COMPLETE, color);
        ColorDto respuesta = colorView.getColorDto(color);
        log.info(Mensajes.Varios.RESPONSE, respuesta);
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }
    /*
     * Creamos nuevo Color
     */
    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseDto> createColor(@Valid @ModelAttribute ColorDto colorDto,BindingResult validationResult,HttpServletRequest request){
        if (validationResult.hasErrors())
            return mensajeService.invalidFields(validationResult, request.getRequestURI());
        Color precolor = colorServicio.getColor(colorDto.getNombre());
        if(Objects.nonNull(precolor))
            return mensajeService.entityExist(request.getRequestURI());
        log.info(Mensajes.Color.Crear.INICIANDO,colorDto);
        Color color = colorServicio.createColor(colorDto);
        log.info(Mensajes.Color.Crear.COMPLETO, color);
        ColorDto respuesta = colorView.getColorDto(color);
        log.info(Mensajes.Varios.RESPONSE, respuesta);
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }
    /*
     * Actualizamos informacion de color
     */
    @PutMapping()
    public @ResponseBody ResponseEntity<ResponseDto> updateColor(@Valid @ModelAttribute ColorDto colorDto,BindingResult validationResult,HttpServletRequest request){
        if (validationResult.hasErrors())
            return mensajeService.invalidFields(validationResult, request.getRequestURI());
        if(Objects.isNull(colorDto.getId()) || colorDto.getId() == 0)
            return mensajeService.entityNotFound(request.getRequestURI());
        log.info(Mensajes.Color.Busqueda.ID,colorDto.getId());
        Color color= colorServicio.updateColor(colorDto);
        ColorDto respuesta = colorView.getColorDto(color);
        log.info(Mensajes.Varios.RESPONSE, respuesta);
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    /*
     * Eliminamos Color
     */
    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteColor(@PathVariable int id){
        log.info(Mensajes.Color.Busqueda.ID,id);
        Color color = colorServicio.getColor(id);
        color.setHabilitado(false);
        log.info(Mensajes.Varios.RESPONSE,"");
        return new ResponseEntity<>(Mensajes.Color.ELIMINADO,HttpStatus.ACCEPTED);
    }
}
