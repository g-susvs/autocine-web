package com.autocine.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.autocine.DTO.PeliculaDTO;
import com.autocine.DTO.PeliculaRequest;
import com.autocine.models.Genero;
import com.autocine.models.Pelicula;
import com.autocine.repository.GeneroRepository;
import com.autocine.repository.PeliculaRepository;

public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    GeneroRepository generoRepository;

    @Override
    public List<PeliculaDTO> getPeliculas() {

        List<PeliculaDTO> listadoDTO = new ArrayList<>();

        List<Object[]> peliculas = peliculaRepository.findPeliculasQM();

        for (Object[] pelicula : peliculas) {
            PeliculaDTO peliculaDTO = new PeliculaDTO();
            peliculaDTO.setId((Long) pelicula[0]);
            peliculaDTO.setTitulo((String) pelicula[1]);
            peliculaDTO.setDuracion((String) pelicula[2]);
            peliculaDTO.setClasificacion((String) pelicula[3]);
            peliculaDTO.setSinopsis((String) pelicula[4]);

            String generosString = (String) pelicula[5];
            String[] generosArray = generosString.split(", ");

            Set<String> generosSet = new HashSet<>();
            for (String genero : generosArray) {
                generosSet.add(genero);
            }

            peliculaDTO.setGeneros(generosSet);

            listadoDTO.add(peliculaDTO);
        }

        return listadoDTO;
    }

    @Override
    public Pelicula save(PeliculaRequest peliculaRequest) {

        Pelicula pelicula = new Pelicula();

        pelicula.setTitulo(peliculaRequest.getTitulo());
        pelicula.setDuracion(peliculaRequest.getDuracion());
        pelicula.setClasificacion(peliculaRequest.getClasificacion());
        pelicula.setSinopsis(peliculaRequest.getSinopsis());

        List<Genero> generosExist = generoRepository.findAllById(peliculaRequest.getGeneros());

        System.out.println("=================");
        System.out.println(generosExist.toString());
        System.out.println("=================");

        Set<Genero> generos = new HashSet<>(generosExist);
        pelicula.setGeneros(generos);

        return peliculaRepository.save(pelicula);
    }

    @Override
    public void delete(Long id) {
        peliculaRepository.deleteById(id);
    }

}
