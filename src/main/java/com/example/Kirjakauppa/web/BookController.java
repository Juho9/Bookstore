package com.example.Kirjakauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Kirjakauppa.domain.Book;
import com.example.Kirjakauppa.domain.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	//All books
	@RequestMapping("/booklist")
	public String booksToList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklistpage";
	}

	
	//Add new book
	@RequestMapping(value="/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	
	//Delete book
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model)  {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	//Edit book
	@RequestMapping(value="/editbook/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		Book book = repository.findById(bookId).get();
		model.addAttribute("book", book);
		return "editbook";
	}
	
	@RequestMapping(value="/editbook/{id}", method = RequestMethod.POST)
	public String editBook(Book book)  {
		repository.save(book);
		return "redirect:../booklist";
	}
	
	
}