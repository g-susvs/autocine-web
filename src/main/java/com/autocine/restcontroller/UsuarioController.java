package com.autocine.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autocine.models.Usuario;
import com.autocine.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioservice;

	@GetMapping
	List<Usuario> getAllUsers() {
		return usuarioservice.getAllUsuarios();
	}

	@PostMapping
	ResponseEntity<Usuario> createUsuario(@RequestBody Usuario newUsuario) {
		System.out.println("guardando");
		return new ResponseEntity<>(usuarioservice.saveUsuario(newUsuario), HttpStatus.CREATED);
	}


}
