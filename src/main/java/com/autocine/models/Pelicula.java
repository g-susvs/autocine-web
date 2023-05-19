package com.autocine.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula", unique = true, nullable = false)
    private Long id;

    private String titulo;
    private String duracion;
    private String sinopsis;
    private String clasificacion;

    @ManyToMany
    @JoinTable(name = "pelicula_genero", joinColumns = { @JoinColumn(name = "pelicula_id") }, inverseJoinColumns = {
            @JoinColumn(name = "genero_id") })
    private Set<Genero> generos = new HashSet<>();

}
