package hu.qwaevisz.bookstore.service;

import java.util.List;

import hu.qwaevisz.bookstore.domain.Book;
import hu.qwaevisz.bookstore.domain.BookCategory;
import hu.qwaevisz.bookstore.holder.BookHolderImpl;

public class BookServiceImpl implements BookService {

	@Override
	public Book saveBook(String isbn, String author, String title, int numberOfPages, double price, BookCategory category) {
		Book book = null;
		if (!BookHolderImpl.getInstance().exists(isbn)) {
			book = BookHolderImpl.getInstance().create(isbn, author, title, numberOfPages, price, category);
		} else {
			book = BookHolderImpl.getInstance().update(isbn, author, title, numberOfPages, price, category);
		}
		return book;
	}

	@Override
	public List<Book> getBooks() {
		return BookHolderImpl.getInstance().readAll();
	}

	@Override
	public List<Book> getBooks(BookCategory category) {
		return BookHolderImpl.getInstance().read(category);
	}

	@Override
	public Book getBook(String isbn) {
		return BookHolderImpl.getInstance().read(isbn);
	}

	@Override
	public void removeBook(String isbn) {
		BookHolderImpl.getInstance().delete(isbn);
	}

	private static BookService instance = null;

	public static BookService getInstance() {
		if (BookServiceImpl.instance == null) {
			synchronized (BookService.class) {
				if (BookServiceImpl.instance == null) {
					BookServiceImpl.instance = new BookServiceImpl();
				}
			}
		}
		return BookServiceImpl.instance;
	}

}
