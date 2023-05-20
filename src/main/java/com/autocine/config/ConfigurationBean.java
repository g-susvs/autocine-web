package com.autocine.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import com.autocine.service.FuncionService;
import com.autocine.service.FuncionServiceImpl;
import com.autocine.service.UsuarioService;
import com.autocine.service.UsuarioServiceImpl;

@Configuration
public class ConfigurationBean {
	@Bean
	UsuarioService usuarioservice() {
		return new UsuarioServiceImpl();
	}
	
	@Bean
	FuncionService funcionservice() {
		return new FuncionServiceImpl();
	}

}
