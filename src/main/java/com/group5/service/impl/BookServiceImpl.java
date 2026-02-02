package com.group5.service.impl;

import java.util.List;

import com.group5.dao.BookDAO;
import com.group5.model.Book;
import com.group5.service.BookService;

public class BookServiceImpl implements BookService {

	private final BookDAO bookDAO;
	
	public BookServiceImpl (BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	@Override
	public List<Book> showAllBooks() {
		return bookDAO.getAllBooks();
	}

}
