package com.example.Kirjakauppa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Kirjakauppa.domain.Book;
import com.example.Kirjakauppa.domain.BookRepository;

@SpringBootApplication
public class KirjakauppaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository)  {
		return (args) -> {
			Book b1 = new Book("Härö Potter", "Panu Dahlqvist", "0545162076", 19.95, 2022);
			Book b2 = new Book("Kalle Kumiankka", "Matias Grahn", "0425037215", 21.90, 1985);
			
			repository.save(b1);
			repository.save(b2);
		};
	}

}
