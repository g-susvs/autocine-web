package com.autocine.restcontroller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.autocine.DTO.PeliculaDTO;
import com.autocine.DTO.PeliculaRequest;
import com.autocine.models.Pelicula;
import com.autocine.service.CloudinaryService;
import com.autocine.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculasController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    List<PeliculaDTO> getPeliculas() {

        return peliculaService.getPeliculas();
    }

    @PostMapping
    ResponseEntity<Pelicula> savePelicula(@RequestBody PeliculaRequest newPelicula) {
        return new ResponseEntity<>(peliculaService.savePeliculaRequest(newPelicula), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Pelicula> deletePelicula(@PathVariable Long id) throws IOException {

        Pelicula pelicula = peliculaService.getPeliculaById(id);

        String urlImagen = pelicula.getImagen();
        String idImagen = "";

        if (urlImagen != null && urlImagen.contains("/") && urlImagen.contains(".")) {
            int lastIndex = urlImagen.lastIndexOf("/");
            int dotIndex = urlImagen.lastIndexOf(".");

            if (lastIndex < dotIndex) {
                idImagen = urlImagen.substring(lastIndex + 1, dotIndex);
            }
        }

        Map result = cloudinaryService.delete("peliculas", idImagen);

        peliculaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/actualizarimg/{id}")
    ResponseEntity<Pelicula> save(@PathVariable Long id, @RequestParam("archivo") MultipartFile multipartFile)
            throws IOException {

        Map result = cloudinaryService.uploaad("peliculas", multipartFile);

        String url = (String) result.get("secure_url");

        Pelicula pelicula = peliculaService.actualizarImg(id, url);

        return new ResponseEntity<>(peliculaService.savePelicula(pelicula), HttpStatus.OK);
    }

}
