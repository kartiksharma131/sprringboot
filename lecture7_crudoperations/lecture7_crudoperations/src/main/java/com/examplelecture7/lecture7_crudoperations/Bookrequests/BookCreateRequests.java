package com.examplelecture7.lecture7_crudoperations.Bookrequests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BookCreateRequests {

	@NotNull
	private String name;
	@NotNull
	private String authorName;
	@Positive
	private int cost;
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
