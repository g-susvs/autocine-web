package com.autocine.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "funcion")

public class Funcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcion", nullable = false, unique = true)
	private Long id;

	@Column
	private Date fecha;

	@Column
	private String hora;

	@Column
	private int cupo;

	@ManyToOne
	@JoinColumn(name = "id_pelicula", nullable = false)
	private Pelicula pelicula;
}
