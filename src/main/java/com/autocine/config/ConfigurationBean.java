package com.autocine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.autocine.service.GeneroService;
import com.autocine.service.GeneroServiceImpl;
import com.autocine.service.PeliculaService;
import com.autocine.service.PeliculaServiceImpl;

@Configuration
public class ConfigurationBean {

    @Bean
    GeneroService generoService() {
        return new GeneroServiceImpl();
    }

    @Bean
    PeliculaService peliculaService() {
        return new PeliculaServiceImpl();
    }
}
