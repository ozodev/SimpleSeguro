package com.simple.seguros.core.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.simple.seguros.core.entidades.tipos.Color;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ColorDto implements ResponseDto{

    public ColorDto(Color color){
        this.id= color.getId();
        this.nombre = color.getNombre();
        this.habilitado = color.isHabilitado();
    }

    private int id;

    @NotEmpty
    @NotBlank
    @NotNull
    private String nombre;

    @NotNull
    private boolean habilitado;
}
