package com.devgabrel.dslist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Configuração do Spring.
public class WebConfig {

	@Value("${cors.origins}") // Injeta as origens permitidas para CORS.
	private String corsOrigins;
	
	@Bean // Configura o CORS.
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Aplica CORS a todas as URLs.
                        .allowedMethods("*") // Permite todos os métodos HTTP.
                        .allowedOrigins(corsOrigins); // Permite origens configuradas.
			}
		};
	}	
}