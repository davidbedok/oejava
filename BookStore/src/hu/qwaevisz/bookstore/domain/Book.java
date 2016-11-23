package hu.qwaevisz.bookstore.domain;

public class Book {

	private String isbn;
	private String author;
	private String title;
	private int numberOfPages;
	private double price;
	private BookCategory category;

	public Book(String isbn, String author, String title, int numberOfPages, double price, BookCategory category) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.numberOfPages = numberOfPages;
		this.price = price;
		this.category = category;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return this.numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public BookCategory getCategory() {
		return this.category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + this.isbn + ", title=" + this.title + ", author=" + this.author + ", numberOfPages=" + this.numberOfPages + ", price="
				+ this.price + ", category=" + this.category + "]";
	}

}
