package hu.qwaevisz.bookstore.service;

import java.util.List;

import hu.qwaevisz.bookstore.domain.Book;
import hu.qwaevisz.bookstore.domain.BookCategory;

public interface BookService {

	List<Book> getBooks();

	List<Book> getBooks(BookCategory category);

	Book getBook(String isbn);

}
