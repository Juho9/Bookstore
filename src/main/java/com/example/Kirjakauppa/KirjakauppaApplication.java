package com.example.Kirjakauppa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Kirjakauppa.domain.Book;
import com.example.Kirjakauppa.domain.BookRepository;
import com.example.Kirjakauppa.domain.Category;
import com.example.Kirjakauppa.domain.CategoryRepository;
import com.example.Kirjakauppa.domain.UserClass;
import com.example.Kirjakauppa.domain.UserClassRepository;

@SpringBootApplication
public class KirjakauppaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, UserClassRepository userClassRepository)  {
		return (args) -> {
			
			Category c1 = new Category("Horror");
			Category c2 = new Category("History");
			Category c3 = new Category("Fiction");
			categoryRepository.save(c1);
			categoryRepository.save(c2);
			categoryRepository.save(c3);
			
			Book b1 = new Book("Harri Potter", "Panu Dahlqvist", "0234345212", 19.95, 1999, c1);
			Book b2 = new Book("Kalle Kumiankka", "Matias Grahn", "0425037215", 21.90, 1985, c3);
			bookRepository.save(b1);
			bookRepository.save(b2);
			
			UserClass u1 = new UserClass("user", "$2a$10$A513IHgxSCGwZHx4WIX8veCS31FT8zccmjFmdC8NfQj4hCZROwsFS", "USER");
			UserClass u2 = new UserClass("admin", "$2a$10$kpy.wde.enrIt59mp9G6y.6dIaCq9dPtTin1yinvOKZTzLmedAEQC", "ADMIN");
			userClassRepository.save(u1);
			userClassRepository.save(u2);
			
		};
	}

}
