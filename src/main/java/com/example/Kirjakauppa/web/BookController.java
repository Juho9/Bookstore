package com.example.Kirjakauppa.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Kirjakauppa.domain.Book;
import com.example.Kirjakauppa.domain.BookRepository;
import com.example.Kirjakauppa.domain.CategoryRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	//All books
	@RequestMapping("/booklist")
	public String booksToList(Model model) {
		model.addAttribute("booklist", bookRepository.findAll());
		model.addAttribute("category", categoryRepository.findAll());
		return "booklistpage";
	}

	
	//Add new book
	@RequestMapping(value="/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/savebook", method = RequestMethod.POST)
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}
	
	
	//Delete book
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model)  {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	//Edit book
	@RequestMapping(value="/editbook/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		Book book = bookRepository.findById(bookId).get();
		model.addAttribute("book", book);
		return "editbook";
	}
	
	@RequestMapping(value="/editbook/{id}", method = RequestMethod.POST)
	public String editBook(Book book)  {
		bookRepository.save(book);
		return "redirect:../booklist";
	}
	
	
	//REST ACTION
	
	//Rest get all books
	@RequestMapping(value="/booksrest", method = RequestMethod.GET) 
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) bookRepository.findAll();
	}
		
	//Rest get book by id
	@RequestMapping(value="/booksrest/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {
		return bookRepository.findById(id);
	}
	
	
}
