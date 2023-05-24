package com.autocine.DTO;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class PeliculaRequest {
    private String titulo;
    private String duracion;
    private String sinopsis;
    private String clasificacion;
    private Set<Short> generos = new HashSet<>();
}
