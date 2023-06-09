package com.autocine.service;

import java.util.List;

import com.autocine.DTO.PeliculaDTO;
import com.autocine.DTO.PeliculaRequest;
import com.autocine.models.Pelicula;

public interface PeliculaService {
    List<PeliculaDTO> getPeliculas();

    PeliculaDTO getPeliculaById(Long id);

    Pelicula save(PeliculaRequest peliculaRequest);

    void delete(Long id);
}
