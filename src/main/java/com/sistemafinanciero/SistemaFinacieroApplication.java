package com.sistemafinanciero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@CrossOrigin(origins = "*")
@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
public class SistemaFinacieroApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SistemaFinacieroApplication.class, args);
	}
	
	@Bean
	public CorsFilter corsFilter() {
		//System.out.print("Entro a cors filter");
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    //config.setAllowCredentials(true); // you USUALLY want this
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("OPTIONS");
	    config.addAllowedMethod("HEAD");
	    config.addAllowedMethod("GET");
	    config.addAllowedMethod("PUT");
	    config.addAllowedMethod("POST");
	    config.addAllowedMethod("DELETE");
	    config.addAllowedMethod("PATCH");
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
}
