package com.autocine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.autocine.models.Genero;
import com.autocine.repository.GeneroRepository;

public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroRepository generoRepository;

    @Override
    public List<Genero> getGeneros() {
        return generoRepository.findAll();

    }

    @Override
    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

}
