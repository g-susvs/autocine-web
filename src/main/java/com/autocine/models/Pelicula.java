package com.autocine.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinTable(name = "pelicula_genero", joinColumns = @JoinColumn(name = "id_pelicula"), inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private Set<Genero> generos = new HashSet<>();

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Funcion> funciones = new ArrayList<>();

}
