package com.examplelecture7.lecture7_crudoperations.models;

import java.sql.Date;
import lombok.Builder;
@Builder
public class Book {
	
	
	
	public Book() {
		super();
	}
	public Book(int id, String name, String authorName, Date publishedDate, int cost, String publisherName) {
		super();
		this.id = id;
		this.name = name;
		this.authorName = authorName;
		this.publishedDate = publishedDate;
		this.cost = cost;
		this.publisherName = publisherName;
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
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	int id;
	String name;
	String authorName;
	Date publishedDate;
	int cost;
	String publisherName;
	 
	
}
