package com.autocine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.autocine.models.Pelicula;
import com.autocine.repository.PeliculaRepository;

public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> getPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public void delete(Long id) {
        peliculaRepository.deleteById(id);
    }

}
