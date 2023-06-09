package com.autocine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.autocine.models.Genero;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autocine.service.GeneroService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private GeneroService generoService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/pelicula/crear")
    public String crearPelicula(Model model) {

        List<Genero> generos = generoService.getGeneros();

        model.addAttribute("generos", generos);
        return "pelicula/formPelicula";
    }

}