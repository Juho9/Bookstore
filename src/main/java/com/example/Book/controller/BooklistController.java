package com.example.Book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Book.domain.Book;
import com.example.Book.domain.BookRepository;

@Controller
public class BooklistController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		
		model.addAttribute("books", repository.findAll());
		
		return "booklistpage";
	}
	
	//Kirjan poisto
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {
	
		repository.deleteById(id);
		return "redirect:../booklist";
	}

	
	//Uuden kirjan luonti
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbookpage";
	}
	
	//Tallennetaan kirja
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	//Muokataan kirjaa
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book");
		return "editbookpage";
	}
}
