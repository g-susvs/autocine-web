package com.autocine.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.engine.AttributeName;
import org.springframework.beans.factory.annotation.Autowired;
import com.autocine.service.PeliculaService;
import com.autocine.DTO.PeliculaDTO;
import com.autocine.models.Pelicula;



@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/peliculas/lista")
    public String lista(Model model) {

        List<PeliculaDTO> peliculas = peliculaService.getPeliculas();
        model.addAttribute("peliculas", peliculas);
        return "pelicula/lista";
    }
}