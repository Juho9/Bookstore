package com.example.Kirjakauppa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String title, author, isbn;
	private double price;
	
	@Column(name="publishing_year")
	private int year;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	@JsonIgnore
	@JsonIgnoreProperties("booklist")
	private Category category;
	

	
	//Constructors
	
	public Book(String title, String author, String isbn, double price, int year, Category category) {
		super();
		this.category = category;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.year = year;
	}

	public Book() {
		this.title = "";
		this.author = "";
		this.isbn = "";
		this.price = 0;
		this.year = 0;
	}
	
	
	public Book(String title, String author, String isbn, double price, int year) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.year = year;
	}

	//Getters
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;

	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrice() {
		return price;
	}

	public int getYear() {
		return year;
	}
	
	public Category getCategory() {
		return category;
	}

	//Setters
	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
				+ ", year=" + year + "]";
	}
	
	
}
