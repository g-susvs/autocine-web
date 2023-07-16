package com.autocine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.autocine.models.Clasificacion;
import com.autocine.repository.ClasificacionRepository;

public class ClasificacionServiceImpl implements ClasificacionService {

    @Autowired
    ClasificacionRepository clasificacionRepository;

    @Override
    public List<Clasificacion> getClasificaciones() {
        return clasificacionRepository.findAll();
    }

    @Override
    public Clasificacion save(Clasificacion clasificacion) {
        return clasificacionRepository.save(clasificacion);
    }

    @Override
    public Clasificacion getClasificacionById(Short id) {
        return clasificacionRepository.findClasificacionById(id);
    }

}
