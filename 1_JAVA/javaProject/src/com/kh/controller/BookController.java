package com.kh.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.vo.Book;

public class BookController {
	private List<Book> bookList = new ArrayList<>();
	
	public BookController() {
		super();
		bookList.add(new Book("자바의 정석", "IT", "남궁성"));
		bookList.add(new Book("SQL의 정석", "IT", "남궁성"));
		bookList.add(new Book("SPRING의 정석", "IT", "남궁성"));
		bookList.add(new Book("REACT의 정석", "IT", "남궁성"));
	}

	public List<Book> getBookList(){
		return bookList;
	}
	
	public boolean insertBook(Book b) {
		return bookList.add(b);
	}
	
	public Book searchBookTitle(String title) {
		for(Book b : bookList) {
			if(b.getTitle().equals(title)) {
				return b;
			}
		}
		return null;
	}
	
	public boolean updateBook(Book oldBook, Book newBook) {
		int i = bookList.indexOf(oldBook);
		Book b = bookList.set(i, newBook);
		return b != null;
	}
	
	public boolean deleteBook(Book b) {
		return bookList.remove(b);
	}

	public List<Book> searchBook(String keyword){
		List<Book> searchBookList = new ArrayList<>();
		for(Book b : bookList) {
			if(b.containKeyword(keyword)) {
				searchBookList.add(b);
			}
		}
		return searchBookList;
	}
}
