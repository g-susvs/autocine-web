package com.autocine.service;

import java.util.List;

import com.autocine.models.Usuario;

public interface UsuarioService {
	List<Usuario> getAllUsuarios();
	Usuario saveUsuario(Usuario usuario);
	Usuario buscarPorUsername(String username);

}
