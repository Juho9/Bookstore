package com.example.Kirjakauppa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Kirjakauppa.domain.Book;
import com.example.Kirjakauppa.domain.BookRepository;
import com.example.Kirjakauppa.domain.Category;
import com.example.Kirjakauppa.domain.CategoryRepository;

@SpringBootApplication
public class KirjakauppaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository)  {
		return (args) -> {
			Book b1 = new Book("Harri Potter", "Panu Dahlqvist", "0545162076", 19.95, 2022);
			Book b2 = new Book("Kalle Kumiankka", "Matias Grahn", "0425037215", 21.90, 1985);
			
			Category c1 = new Category("Horror");
			Category c2 = new Category("History");
			Category c3 = new Category("Fiction");
			
			bookRepository.save(b1);
			bookRepository.save(b2);
			
			categoryRepository.save(c1);
			categoryRepository.save(c2);
			categoryRepository.save(c3);
		};
	}

}
