package com.autocine.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autocine.models.Clasificacion;
import com.autocine.service.ClasificacionService;

@RestController
@RequestMapping("/api/clasificacion")
public class ClasificacionController {

    @Autowired
    private ClasificacionService clasificacionService;

    @GetMapping
    List<Clasificacion> getClasificaciones() {
        return clasificacionService.getClasificaciones();
    }

    @PostMapping
    ResponseEntity<Clasificacion> saveClasificacion(@RequestBody Clasificacion clasificacion) {
        return new ResponseEntity<>(clasificacionService.save(clasificacion), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Clasificacion> getClasi(@PathVariable Short id) {
        return new ResponseEntity<>(clasificacionService.getClasificacionById(id), HttpStatus.OK);
    }
}
