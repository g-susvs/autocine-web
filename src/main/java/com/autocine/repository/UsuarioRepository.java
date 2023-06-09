package com.autocine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autocine.models.Usuario;
//security
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	//security
	Optional<Usuario>findOneByEmail(String email);

}
