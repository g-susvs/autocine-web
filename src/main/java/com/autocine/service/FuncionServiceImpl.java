package com.autocine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.autocine.repository.FuncionRepository;
import com.autocine.models.Funcion;

public class FuncionServiceImpl implements FuncionService{
	
	@Autowired
	FuncionRepository funcionRepository;
	
	@Override
	public List<Funcion> getAllFuncion(){
		return funcionRepository.findAll();
	}
	
	@Override
	public Funcion saveFuncion(Funcion funcion) {
		return funcionRepository.save(funcion);
	}
	
	@Override
	public Funcion updatFuncion(Long id, Funcion newFuncion) {
		Optional<Funcion> optionalFuncion = funcionRepository.findById(id);
		
		if(optionalFuncion.isPresent()) {
			return null;
		}else {
			return null;
		}
	}

	@Override
	public void deleteFuncion(Long id) {
		funcionRepository.deleteById(id);
		
	}
}
