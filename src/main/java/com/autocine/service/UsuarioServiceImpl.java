package com.autocine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.autocine.models.Usuario;
import com.autocine.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteUsuario(Long id) {
		usuarioRepository.deleteById(id);

	}

}
