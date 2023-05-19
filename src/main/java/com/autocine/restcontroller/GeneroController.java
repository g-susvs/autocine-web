package com.autocine.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autocine.models.Genero;
import com.autocine.service.GeneroService;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    List<Genero> getGeneros() {
        return generoService.getGeneros();
    }

    @PostMapping
    ResponseEntity<Genero> saveGenero(@RequestBody Genero newGenero) {
        return new ResponseEntity<>(generoService.save(newGenero), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Genero> deleteGenero(@PathVariable Short id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
