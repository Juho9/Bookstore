package com.example.Kirjakauppa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> booklist;
	 
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO) 
	 private long categoryId;
	 private String name;
	 
	 
	 public Category() {
		 this.name = "";
	 }
	 
	 
	 public Category(String name) {
		super();
		this.name = name;
	}
	//Getters
	public long getCategoryId() {
		return categoryId;
	}
	public String getName() {
		return name;
	}
	public List<Book> getBooks() {
		return booklist;
	}
	
	
	//Setters
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBooks(List<Book> booklist) {
		this.booklist = booklist;
	}
	
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}
	 
	 

}
