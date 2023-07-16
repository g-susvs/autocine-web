package com.autocine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autocine.models.Clasificacion;

public interface ClasificacionRepository extends JpaRepository<Clasificacion, Short> {

    Clasificacion findClasificacionById(Short id);
}
