package com.autocine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autocine.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findOneByEmail(String email);

}
