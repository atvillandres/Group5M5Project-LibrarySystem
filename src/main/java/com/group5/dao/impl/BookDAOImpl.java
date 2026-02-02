package com.group5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.group5.dao.BookDAO;
import com.group5.model.Book;
import com.group5.util.DBUtil;


public class BookDAOImpl implements BookDAO {

	private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);

	List<Book> booklist = new ArrayList<>();
	
	@Override
	public List<Book> getAllBooks()  {
		
		final String SHOW_ALL_BOOKS = 
				"SELECT id,title,author,isBorrowed FROM book";
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(SHOW_ALL_BOOKS);
				ResultSet rs = ps.executeQuery()) {

			while(rs.next()) {
				booklist.add(new Book(
						rs.getString("id"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getBoolean("isBorrowed")));
			}

			if (booklist.isEmpty()) {
				logger.error("No Books loaded in the table.");
				throw new IllegalArgumentException("No Books Loaded in the table.");
			}
			return booklist;
			
		} catch (SQLException e) {
			logger.error("Failed to load all books." + e.getMessage());
			throw new IllegalArgumentException("Unable to show all books. " + e);
		}
				
		
		
	}

	@Override
	public List<Book> getAvailableBooks() {
		// TODO: Insert code get all available books.
		return booklist;
		
	}

	@Override
	public List<Book> getBorrowedBooks() {
		// TODO: insert code to get all borrowed books
		return booklist;
		
	}

}
