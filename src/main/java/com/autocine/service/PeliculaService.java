package com.autocine.service;

import java.util.List;

import com.autocine.DTO.PeliculaDTO;
import com.autocine.DTO.PeliculaRequest;
import com.autocine.models.Pelicula;

public interface PeliculaService {
    List<PeliculaDTO> getPeliculas();

    Pelicula getPeliculaById(Long id);

    PeliculaDTO getPeliculaByIdQMDto(Long id);

    Pelicula savePelicula(Pelicula pelicula);

    Pelicula savePeliculaRequest(PeliculaRequest peliculaRequest);

    void delete(Long id);

    Pelicula actualizarImg(Long id, String url);
}
