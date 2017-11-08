package hu.qwaevisz.bookstore.holder;

import java.util.List;

import hu.qwaevisz.bookstore.domain.Book;
import hu.qwaevisz.bookstore.domain.BookCategory;

public interface BookHolder {

	boolean exists(String isbn);

	Book create(String isbn, String author, String title, int numberOfPages, double price, BookCategory category);

	List<Book> readAll();

	List<Book> read(BookCategory category);

	Book read(String isbn);

	Book update(String isbn, String author, String title, int numberOfPages, double price, BookCategory category);

	void delete(String isbn);

}
