package com.autocine.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.autocine.DTO.PeliculaDTO;
import com.autocine.DTO.PeliculaRequest;
import com.autocine.models.Clasificacion;
import com.autocine.models.Genero;
import com.autocine.models.Pelicula;
import com.autocine.repository.ClasificacionRepository;
import com.autocine.repository.GeneroRepository;
import com.autocine.repository.PeliculaRepository;

public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    GeneroRepository generoRepository;
    @Autowired
    ClasificacionRepository clasificacionRepository;

    @Override
    public List<PeliculaDTO> getPeliculas() {

        List<PeliculaDTO> listadoDTO = new ArrayList<>();

        List<Object[]> peliculas = peliculaRepository.findPeliculasQM();

        System.out.println("===================");
        for (Object[] pelicula : peliculas) {
            PeliculaDTO peliculaDTO = new PeliculaDTO();
            peliculaDTO.setId((Long) pelicula[0]);
            peliculaDTO.setTitulo((String) pelicula[1]);
            peliculaDTO.setDuracion((String) pelicula[2]);
            peliculaDTO.setSinopsis((String) pelicula[3]);
            peliculaDTO.setImagen((String) pelicula[4]);
            peliculaDTO.setClasificacion((Short) pelicula[5]);

            String generosString = (String) pelicula[6];
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
    public Pelicula savePeliculaRequest(PeliculaRequest peliculaRequest) {

        Pelicula pelicula = new Pelicula();

        pelicula.setTitulo(peliculaRequest.getTitulo());
        pelicula.setDuracion(peliculaRequest.getDuracion());

        Clasificacion clasificacion = clasificacionRepository.findClasificacionById(peliculaRequest.getClasificacion());
        pelicula.setClasificacion(clasificacion);
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

    @Override
    public PeliculaDTO getPeliculaByIdQMDto(Long id) {
        List<Object[]> peliculas = peliculaRepository.findPeliculaByIdQM(id);
        PeliculaDTO peliculaDTO = new PeliculaDTO();

        for (Object[] p : peliculas) {
            peliculaDTO.setId(((Long) p[0]));
            peliculaDTO.setTitulo((String) p[1]);
            peliculaDTO.setDuracion((String) p[2]);
            peliculaDTO.setSinopsis((String) p[3]);
            peliculaDTO.setImagen((String) p[4]);
            peliculaDTO.setClasificacion((Short) p[5]);

            String generosString = (String) p[6];
            String[] generosArray = generosString.split(", ");

            Set<String> generosSet = new HashSet<>();
            for (String genero : generosArray) {
                generosSet.add(genero);
            }
            peliculaDTO.setGeneros(generosSet);
        }
        System.out.println("=============");
        System.out.println(peliculaDTO.getTitulo());
        System.out.println("=============");

        return peliculaDTO;
    }

    @Override
    public Pelicula actualizarImg(Long id, String url) {
        Pelicula pelicula = peliculaRepository.findPeliculaById(id);

        pelicula.setImagen(url);

        peliculaRepository.save(pelicula);

        return pelicula;
    }

    @Override
    public Pelicula savePelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula getPeliculaById(Long id) {
        return peliculaRepository.findPeliculaById(id);
    }

}
