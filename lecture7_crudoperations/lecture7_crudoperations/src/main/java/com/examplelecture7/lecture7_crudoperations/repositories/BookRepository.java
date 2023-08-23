package com.examplelecture7.lecture7_crudoperations.repositories;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.examplelecture7.lecture7_crudoperations.models.Book;

@Repository
public class BookRepository {
	
	private static Connection connection;
	public BookRepository() throws SQLException {
		
		// TODO Auto-generated constructor stub
		
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookInfo","root","123K@sH3210");
		createTable();
	}
	
	 
	
	private void createTable() throws SQLException {
		
		String sql = "create table if not exists book(id int primary key auto_increment,name varchar(30),author_name varchar(30),cost int)";
		Statement stmnt = connection.createStatement();
		int result= stmnt.executeUpdate(sql);
		
	}
	
	public void insert(Book book) throws SQLException {
		String sql = "insert into book(name,author_name,cost) VALUES(?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, book.getName());
		statement.setString(2, book.getAuthorName());
		statement.setInt(3, book.getCost());
		
	}
		/*
		 * statement.execute    --- returns true when there is result set else returns false
		 * when to use  -> can be used when you have some data in the table
		 * 
		 *  execute update -> it will return the number of row or records updated or affected
		 *  it should be used with NON-SELECT queries
		 *  
		 *  execute query  -> it will return the result set
		 *  should be used with SELET queries
		*/



	public Book getBookById(int bookId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from book where id="+bookId;
		Statement stmnt = connection.createStatement();
		ResultSet resultSet =stmnt.executeQuery(sql);
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String bookName =resultSet.getString("name");
			String authorName =resultSet.getString("author_name");
			int cost = resultSet.getInt("cost");
			return  Book.builder().id(id).name(bookName).authorName(authorName).cost(cost).build();
		}
		return null;
		
	}



	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		String sql = "select * from book ";
		Statement stmnt = connection.createStatement();
		ResultSet resultSet =stmnt.executeQuery(sql);
		List<Book> booklist = new ArrayList<>();
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String bookName =resultSet.getString("name");
			String authorName =resultSet.getString("author_name");
			int cost = resultSet.getInt("cost");
			
			Book book= Book.builder().id(id).name(bookName).authorName(authorName).cost(cost).build();
			booklist.add(book);
			
		}
		return booklist;
	}



	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}



	public Book deleteBook(int id) {
		// TODO Auto-generated method stub
		return null;
	}
		
		
		
		/*
		 * DDL-> data definition language (create, drop, alter, truncate)
		 * 		when we want to change the table structure or create a table
		 * DML-> data manipulation language
		 * 		when we want to make any changes to the data present in a table
		 * 		update ,insert ,delete
		 * DQL-> to retrieve the data from the DB
		 * 		Select
		 * DCL -> when we want to give permissions or access to some user
		 * 		grant ,revoke, 
		 * TCL ->
		 *       commit, rollback
		 */
		
	
}
