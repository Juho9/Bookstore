package com.example.Kirjakauppa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO) 
	 private long categoryId;
	 private String name;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	 @JsonIgnoreProperties("category")
	 private List<Book> booklist;
	 
	 
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
