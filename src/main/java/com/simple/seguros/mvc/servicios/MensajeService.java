package com.simple.seguros.mvc.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.simple.seguros.core.Mensajes;
import com.simple.seguros.core.dtos.InvalidDto;
import com.simple.seguros.core.dtos.ResponseDto;

@Service
public class MensajeService {
    
    public List<String> validErros(BindingResult validationResult) {
        return validationResult.getFieldErrors().stream()
                .map(err -> "El Campo '" + err.getField() + "' " + err.getDefaultMessage())
                .collect(Collectors.toList());
    }

    
    public ResponseEntity<ResponseDto> entityNotFound(String path) {
        InvalidDto response = new InvalidDto(Mensajes.Varios.ENTITYNOTFOUND, path);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    
    public ResponseEntity<ResponseDto> entityExist(String path) {
        InvalidDto response = new InvalidDto(Mensajes.Varios.ENTITYEXIST, path);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    
    public ResponseEntity<ResponseDto> invalidFields(BindingResult validationResult, String path) {
        List<String> errors = validErros(validationResult);
        InvalidDto response = new InvalidDto(Mensajes.Varios.INVALIDFIELDS, errors, path);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<ResponseDto> invalidFields(String error, String path) {
        List<String> errors = new ArrayList<>();
        errors.add(error);
        InvalidDto response = new InvalidDto(Mensajes.Varios.INVALIDFIELDS, errors, path);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    
    public ResponseEntity<ResponseDto> entityNotFound(String id, String path) {
        List<String> errors = new ArrayList<>();
        errors.add("Id: " + id + " Not Found");
        return new ResponseEntity<>(new InvalidDto(Mensajes.Varios.ENTITYNOTFOUND, errors, path),
                HttpStatus.BAD_REQUEST);
    }
}
