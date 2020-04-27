package com.tryouts.library;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.tryouts.library.models.Book;
import com.tryouts.library.repository.BookRepository;

@SpringBootApplication
@EnableJpaRepositories("com.tryouts.library.repository") 
@EntityScan("com.tryouts.library.models")   
public class LibraryMgmntApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryMgmntApplication.class, args);
	}
	
//	@Bean
//	  public CommandLineRunner init(BookRepository repository) {
//	    return (args) -> {
//	    	repository.save(new Book("Secret Seven","Enid Blyton","Penguin"));
//			repository.save(new Book("Famous Five","Enid Blyton","Penguin"));
//			repository.findAll().forEach(s -> System.out.println(s.getBook_name()));
//	    };
//	}
	
	@Bean
	public CorsFilter corsFilter() {
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration config = new CorsConfiguration();
	config.setAllowCredentials(true);
	config.addAllowedOrigin("*");
	config.addAllowedHeader("*");
	config.addAllowedMethod("OPTIONS");
	config.addAllowedMethod("GET");
	config.addAllowedMethod("POST");
	config.addAllowedMethod("PUT");
	config.addAllowedMethod("DELETE");
	source.registerCorsConfiguration("/**", config);
	return new CorsFilter(source);
	}
}
