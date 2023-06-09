package com.autocine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.autocine.DTO.PeliculaDTO;
import com.autocine.models.Genero;
import com.autocine.service.GeneroService;
import com.autocine.service.PeliculaService;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private GeneroService generoService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/crear")
    public String crearPelicula(Model model) {

        List<Genero> generos = generoService.getGeneros();

        model.addAttribute("generos", generos);
        return "pelicula/formPelicula";
    }

    @GetMapping("/lista")
    public String lista(Model model) {

        List<PeliculaDTO> peliculas = peliculaService.getPeliculas();
        model.addAttribute("peliculas", peliculas);
        return "pelicula/lista";
    }

    @GetMapping("/detalle/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        PeliculaDTO pelicula = peliculaService.getPeliculaById(id);

        model.addAttribute("pelicula", pelicula);
        return "pelicula/detalle";
    }
}
