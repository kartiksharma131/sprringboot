package com.examplelecture7.lecture7_crudoperations.services;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplelecture7.lecture7_crudoperations.Bookrequests.BookUpdateRequest;
import com.examplelecture7.lecture7_crudoperations.models.Book;
import com.examplelecture7.lecture7_crudoperations.repositories.BookRepository;
@Service
public class BookService {

	@Autowired
	BookRepository bookrepo;
	
	public void insert(Book book) throws SQLException {
		bookrepo.insert(book);
	}

	public Book getBook(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		return bookrepo.getBookById(id);
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookrepo.getAllBooks();
	}

	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		String sql = "update book set cost=?,name=?,author_name=?"+ "where id=?"
		return bookrepo.updateBook(book);
	}

	public Book deleteBook(int id) {
		// TODO Auto-generated method stub
		return bookrepo.deleteBook(id);
	}
}
