package com.autocine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autocine.DTO.PeliculaDTO;
import com.autocine.models.Clasificacion;
import com.autocine.models.Genero;
import com.autocine.models.Pelicula;
import com.autocine.service.ClasificacionService;
import com.autocine.service.GeneroService;
import com.autocine.service.PeliculaService;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private GeneroService generoService;

    @Autowired
    private ClasificacionService clasificacionService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/crear")
    public String crearPelicula(Model model) {

        List<Genero> generos = generoService.getGeneros();
        List<Clasificacion> clasificaciones = clasificacionService.getClasificaciones();

        model.addAttribute("generos", generos);
        model.addAttribute("clasificaciones", clasificaciones);

        return "pelicula/formPelicula";
    }

    // asignar imagen a la pelicula
    @GetMapping("/formimg/{id}")
    public String formImg(@PathVariable Long id, Model model) {

        Pelicula pelicula = peliculaService.getPeliculaById(id);

        model.addAttribute("Pelicula", pelicula);

        return "pelicula/formUpload";
    }

    @GetMapping("/lista")
    public String lista(Model model) {

        List<PeliculaDTO> peliculas = peliculaService.getPeliculas();
        model.addAttribute("peliculas", peliculas);
        return "pelicula/lista";
    }

    @GetMapping("/detalle/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        PeliculaDTO pelicula = peliculaService.getPeliculaByIdQMDto(id);

        System.out.println("=========");
        System.out.println(pelicula.getClasificacion());

        model.addAttribute("pelicula", pelicula);
        model.addAttribute("clasificacion", pelicula);
        return "pelicula/detalle";
    }
}
