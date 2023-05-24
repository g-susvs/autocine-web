package com.autocine.DTO;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class PeliculaDTO {
    private Long id;
    private String titulo;
    private String duracion;
    private String sinopsis;
    private String clasificacion;
    private Set<String> generos = new HashSet<>();
}

// private String generos;