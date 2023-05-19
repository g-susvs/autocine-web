package com.autocine.service;

import java.util.List;

import com.autocine.models.Genero;

public interface GeneroService {
    List<Genero> getGeneros();

    Genero save(Genero genero);

    void delete(Short id);
}
