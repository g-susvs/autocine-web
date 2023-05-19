package com.autocine.service;

import java.util.List;

import com.autocine.models.Pelicula;

public interface PeliculaService {
    List<Pelicula> getPeliculas();

    Pelicula save(Pelicula pelicula);

    void delete(Long id);
}
