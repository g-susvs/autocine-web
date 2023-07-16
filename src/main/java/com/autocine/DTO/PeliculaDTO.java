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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public Set<String> getGeneros() {
		return generos;
	}
	public void setGeneros(Set<String> generos) {
		this.generos = generos;
	}
    
    
}

// private String generos;