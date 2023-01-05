package com.simple.seguros.core.dtos;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class InvalidDto implements ResponseDto{
    private List<String> errors;
    private String mensaje;
    private String timestamp;
    private String path;

    public InvalidDto(String mensaje, List<String> errors, String path) {
        this.mensaje = mensaje;
        this.errors = errors;
        this.timestamp = new Timestamp(System.currentTimeMillis()).toString();
        this.path = path;
    }

    public InvalidDto(String mensaje, String path) {
        this(mensaje,null,path);
    }
}