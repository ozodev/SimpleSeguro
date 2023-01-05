package com.simple.seguros.mvc.servicios;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simple.seguros.core.dtos.ColorDto;
import com.simple.seguros.core.entidades.tipos.Color;
import com.simple.seguros.mvc.repositorios.ColorRepositorio;

@Service
public class ColorServicio {

    @Autowired
    private ColorRepositorio colorRepositorio;
    
    @Transactional(readOnly= true)
    public Page<Color> getColores(){
        return colorRepositorio.findAll(Pageable.ofSize(10));
    }

    @Transactional(readOnly= true)
    public Color getColor(int id){
        return colorRepositorio.findById(id).orElse(null);
    }

    @Transactional(readOnly= true)
    public Color getColor(String nombre){
        return colorRepositorio.findByNameOrId(nombre).orElse(null);
    }

    @Transactional
    public Color createColor(ColorDto colordto){
        Color color = new Color(colordto);
        return colorRepositorio.save(color);
    }

    @Transactional
    public Color updateColor(Color color){
        Color anteriorColor = this.getColor(color.getId());
        if(Objects.isNull(anteriorColor)) anteriorColor = new Color();
        anteriorColor.update(color);
        return colorRepositorio.save(anteriorColor);
    }
    @Transactional
    public Color updateColor(ColorDto color){
        Color nuevoColor = new Color(color);
        return this.updateColor(nuevoColor);
    }

    @Transactional
    public void deleteColor(int id){
        Color color = this.getColor(id);
        if(color!=null) color.setHabilitado(false);
    }

}