package com.simple.seguros.mvc.vistas;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.simple.seguros.core.dtos.ColorDto;
import com.simple.seguros.core.dtos.PageDto;
import com.simple.seguros.core.entidades.tipos.Color;

@Service
public class ColorView {
    
    public PageDto getColorPageDto(Page<Color> page){
        PageDto dto= new PageDto(page);
        dto.setContent(page.getContent().stream().map(ColorDto::new).collect(Collectors.toList()));
        return dto;
    }

    public ColorDto getColorDto(Color color){
        return new ColorDto(color);
    }
}
