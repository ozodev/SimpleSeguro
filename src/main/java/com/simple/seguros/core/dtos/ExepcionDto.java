package com.simple.seguros.core.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExepcionDto {
    private String timestamp;
    private int status;
    private String error;
    private String mensaje;
}