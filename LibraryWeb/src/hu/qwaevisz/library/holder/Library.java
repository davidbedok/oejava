package hu.qwaevisz.library.holder;

import java.util.ArrayList;
import java.util.List;

import hu.qwaevisz.library.domain.Book;
import hu.qwaevisz.library.domain.BookCategory;

public class Library {

	private List<Book> books;

	private Library() {
		this.books = new ArrayList<>();
		this.add(new Book("978-0441172719", "Frank Herbert", "Dune", BookCategory.SCIFI, 3500, 896));
		this.add(new Book("978-0345391803", "Douglas Adams", "The Hitchhiker's Guide to the Galaxy", BookCategory.SCIFI, 2100, 224));
		this.add(new Book("978-5955000831", "Paulo Coelho", "Veronika Decides to Die", BookCategory.LITERATURE, 2300, 240));
	}

	public void add(Book book) {
		this.books.add(book);
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public List<Book> getBooks(BookCategory category) {
		List<Book> result = new ArrayList<>();
		for (Book book : this.books) {
			if (book.getCategory() == category) {
				result.add(book);
			}
		}
		return result;
	}

	public Book find(String isbn) {
		Book result = null;
		for (Book book : this.books) {
			if (book.getIsbn().equals(isbn)) {
				result = book;
				break;
			}
		}
		return result;
	}

	private static Library instance = null;

	public static Library getInstance() {
		if (instance == null) {
			synchronized (Library.class) {
				if (instance == null) {
					instance = new Library();
				}
			}
		}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
