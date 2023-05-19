package com.autocine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autocine.models.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}
