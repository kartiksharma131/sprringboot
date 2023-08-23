package com.examplelecture7.lecture7_crudoperations.Bookrequests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BookUpdateRequest {
	
	@Positive
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String authorName;
	@Positive
	private int cost;
	
	//getters and setters
	
	public Book to() {
		return Book.builder.id(this.id).name(this.name).authorName(this.authorName).cost(this.cost).build();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
