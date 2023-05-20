package com.autocine.service;

import java.util.List;

import com.autocine.models.Funcion;

public interface FuncionService {
List<Funcion>getAllFuncion();
	
	Funcion saveFuncion(Funcion funcion);

	Funcion updatFuncion(Long id, Funcion newFuncion);

    void deleteFuncion(Long id);

}
