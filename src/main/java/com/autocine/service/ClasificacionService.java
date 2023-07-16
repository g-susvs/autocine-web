package com.autocine.service;

import java.util.List;

import com.autocine.models.Clasificacion;

public interface ClasificacionService {
    List<Clasificacion> getClasificaciones();

    Clasificacion getClasificacionById(Short id);

    Clasificacion save(Clasificacion clasificacion);
}
