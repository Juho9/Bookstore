package com.example.Kirjakauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Kirjakauppa.domain.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping("/booklist")
	public String booksToList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklistpage";
	}

}
