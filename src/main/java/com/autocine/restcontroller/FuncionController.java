package com.autocine.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autocine.models.Funcion;
import com.autocine.service.FuncionService;

@RestController
@RequestMapping("/api/funcion")
public class FuncionController {

	@Autowired
	private FuncionService funcionservice;

	@GetMapping
	List<Funcion> getAllFuncion() {
		return funcionservice.getAllFuncion();
	}

	@PostMapping
	ResponseEntity<Funcion> createFuncion(@RequestBody Funcion newFuncion) {
		return new ResponseEntity<>(funcionservice.saveFuncion(newFuncion), HttpStatus.CREATED);
	}

}
