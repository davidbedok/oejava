package hu.qwaevisz.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import hu.qwaevisz.bookstore.domain.Book;
import hu.qwaevisz.bookstore.domain.BookCategory;

public class BookServiceImpl implements BookService {

	private List<Book> books;

	private BookServiceImpl() {
		this.books = new ArrayList<>();
		this.books.add(new Book("978-0441172719", "Frank Herbert", "Dune", 896, 3500, BookCategory.SCIFI));
		this.books.add(new Book("978-5955000831", "Paulo Coelho", "Veronika Decides to Die", 240, 2300, BookCategory.LITERATURE));
		this.books.add(new Book("978-0684824710", "Daniel C. Dennett", "Darwin's dangerous idea", 586, 4500, BookCategory.PHILOSOPHY));
	}

	@Override
	public Book saveBook(String isbn, String author, String title, int numberOfPages, double price, BookCategory category) {
		Book book = this.getBook(isbn);
		if (book == null) {
			book = new Book(isbn, author, title, numberOfPages, price, category);
			this.books.add(book);
		} else {
			book.setAuthor(author);
			book.setTitle(title);
			book.setNumberOfPages(numberOfPages);
			book.setPrice(price);
			book.setCategory(category);
		}
		return book;
	}

	@Override
	public List<Book> getBooks() {
		return this.books;
	}

	@Override
	public List<Book> getBooks(BookCategory category) {
		List<Book> result = new ArrayList<>();
		for (Book book : this.books) {
			if (book.getCategory() == category) {
				result.add(book);
			}
		}
		return result;
	}

	@Override
	public Book getBook(String isbn) {
		Book result = null;
		for (Book book : this.books) {
			if (book.getIsbn().equals(isbn)) {
				result = book;
				break;
			}
		}
		return result;
	}

	@Override
	public void removeBook(String isbn) {
		this.books.remove(this.getBook(isbn));
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
