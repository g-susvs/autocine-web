package com.autocine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.autocine.service.FuncionService;
import com.autocine.service.FuncionServiceImpl;
import com.autocine.service.UsuarioService;
import com.autocine.service.UsuarioServiceImpl;

import com.autocine.service.GeneroService;
import com.autocine.service.GeneroServiceImpl;
import com.autocine.service.PeliculaService;
import com.autocine.service.PeliculaServiceImpl;

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

    @Bean
    GeneroService generoService() {
        return new GeneroServiceImpl();
    }

    @Bean
    PeliculaService peliculaService() {
        return new PeliculaServiceImpl();
    }
}
