package com.autocine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autocine.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
