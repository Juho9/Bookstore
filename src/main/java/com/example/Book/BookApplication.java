package com.example.Book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Book.domain.BookRepository;
import com.example.Book.domain.Book;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			
			Book b1 = new Book("Harry Potter", "J.K Rowling", 1997, "9780590353403", 12.99);
			Book b2 = new Book("Sinuhe Egyptiläinen", "Mika Waltari", 1945, "9789510098752", 22.50);
			Book b3 = new Book("Kimi Räikkönen", "Kari Hotakainen", 2018, "978-952-234-538-7", 17.99);
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
			
		};
	}

}
