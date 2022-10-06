package com.example.Kirjakauppa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	 
	 
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
	
	
	//Setters
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}
	 
	 

}
