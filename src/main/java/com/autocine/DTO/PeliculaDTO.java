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
	private Short clasificacion;
	private String imagen;
	private Set<String> generos = new HashSet<>();

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getSinopsis() {
		return this.sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Short getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(Short clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Set<String> getGeneros() {
		return this.generos;
	}

	public void setGeneros(Set<String> generos) {
		this.generos = generos;
	}

}

// private String generos;