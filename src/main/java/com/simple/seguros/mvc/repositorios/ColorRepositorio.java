package com.simple.seguros.mvc.repositorios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.simple.seguros.core.entidades.tipos.Color;

public interface ColorRepositorio extends JpaRepository<Color,Integer>, JpaSpecificationExecutor<Color> {

    @Query(value = "select c from Color c where c.habilitado=:habilitado")
    public Page<Color> findAllByEnable(@Param("habilitado") boolean habilitado, Pageable pageable);

    @Query(value = "select c from Color c where c.nombre=:id or c.id=:id")
    public Optional<Color> findByNameOrId(@Param("id") String id);
}