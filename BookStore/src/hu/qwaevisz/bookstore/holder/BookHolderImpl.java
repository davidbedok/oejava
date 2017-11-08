package hu.qwaevisz.bookstore.holder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hu.qwaevisz.bookstore.domain.Book;
import hu.qwaevisz.bookstore.domain.BookCategory;

public class BookHolderImpl implements BookHolder {

	private List<Book> books;

	private BookHolderImpl() {
		this.books = new ArrayList<>();
		this.books.add(new Book("978-0441172719", "Frank Herbert", "Dune", 896, 3500, BookCategory.SCIFI));
		this.books.add(new Book("978-5955000831", "Paulo Coelho", "Veronika Decides to Die", 240, 2300, BookCategory.LITERATURE));
		this.books.add(new Book("978-0684824710", "Daniel C. Dennett", "Darwin's dangerous idea", 586, 4500, BookCategory.PHILOSOPHY));
	}

	@Override
	public boolean exists(String isbn) {
		return this.books.stream().anyMatch(b -> b.getIsbn().equals(isbn));
	}

	@Override
	public Book create(String isbn, String author, String title, int numberOfPages, double price, BookCategory category) {
		Book book = new Book(isbn, author, title, numberOfPages, price, category);
		this.books.add(book);
		return book;
	}

	@Override
	public List<Book> readAll() {
		return this.books;
	}

	@Override
	public List<Book> read(BookCategory category) {
		return this.books.stream().filter(b -> b.getCategory() == category).collect(Collectors.toList());
	}

	@Override
	public Book read(String isbn) {
		return this.books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().get();
	}

	@Override
	public Book update(String isbn, String author, String title, int numberOfPages, double price, BookCategory category) {
		Book result = this.read(isbn);
		if (result != null) {
			result.setAuthor(author);
			result.setTitle(title);
			result.setNumberOfPages(numberOfPages);
			result.setPrice(price);
			result.setCategory(category);
		}
		return result;
	}

	@Override
	public void delete(String isbn) {
		this.books.removeIf(b -> b.getIsbn().equals(isbn));
	}

	private static BookHolder instance = null;

	public static BookHolder getInstance() {
		if (BookHolderImpl.instance == null) {
			synchronized (BookHolderImpl.class) {
				if (BookHolderImpl.instance == null) {
					BookHolderImpl.instance = new BookHolderImpl();
				}
			}
		}
		return BookHolderImpl.instance;
	}

}
