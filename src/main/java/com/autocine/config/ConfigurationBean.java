package com.autocine.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.autocine.service.ClasificacionService;
import com.autocine.service.ClasificacionServiceImpl;
import com.autocine.service.FuncionService;
import com.autocine.service.FuncionServiceImpl;
import com.autocine.service.UsuarioService;
import com.autocine.service.UsuarioServiceImpl;
import com.cloudinary.Cloudinary;
import com.autocine.service.GeneroService;
import com.autocine.service.GeneroServiceImpl;
import com.autocine.service.PeliculaService;
import com.autocine.service.PeliculaServiceImpl;

@Configuration
public class ConfigurationBean {

    @Value("${cloudinary.cloud-name}")
    private String cloudName;

    @Value("${cloudinary.api-key}")
    private String apiKey;

    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    @Bean
    Cloudinary cloudinaryConfig() {
        return new Cloudinary("cloudinary://"
                + apiKey + ":"
                + apiSecret + "@"
                + cloudName);
    }

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

    @Bean
    ClasificacionService clasificacionService() {
        return new ClasificacionServiceImpl();
    }
}
