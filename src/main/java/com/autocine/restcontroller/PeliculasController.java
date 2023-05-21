package com.autocine.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autocine.models.Pelicula;
import com.autocine.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculasController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    List<Pelicula> getPeliculas() {
        return peliculaService.getPeliculas();
    }

    @PostMapping
    ResponseEntity<Pelicula> savePelicula(@RequestBody Pelicula newPelicula) {
        return new ResponseEntity<>(peliculaService.save(newPelicula), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Pelicula> deletePelicula(@PathVariable Long id) {
        peliculaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
