package com.autocine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.autocine.models.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    @Query(value = "SELECT p.id_pelicula, p.titulo, p.duracion, p.clasificacion, p.sinopsis, " +
            "GROUP_CONCAT(g.nombre SEPARATOR ', ') AS generos " +
            "FROM peliculas p " +
            "JOIN pelicula_genero pg ON p.id_pelicula = pg.id_pelicula " +
            "JOIN generos g ON g.id_genero = pg.id_genero " +
            "GROUP BY p.id_pelicula, p.titulo", nativeQuery = true)
    List<Object[]> findPeliculasQM();
}
