package hu.zskf.library.main;

import hu.zskf.library.base.Book;

public class Library extends Object {

	private static final int MAX_BOOKS = 10;
	private final String name;
	private final Book[] books;
	private int index;

	public Library(String name) {
		this.name = name;
		this.books = new Book[Library.MAX_BOOKS];
		this.index = 0;
	}

	public void add(Book book) {
		if (this.index < Library.MAX_BOOKS) {
			this.books[this.index++] = book;
		}
	}

	public String borrow(String name, String title) {
		String ret = "";
		Book book = this.find(title);
		if (book != null) {
			ret = book.borrow(name);
		}
		return ret;
	}

	private Book find(String title) {
		Book ret = null;
		for (int i = 0; i < this.index; i++) {
			if (this.books[i].getTitle().equals(title)) {
				ret = this.books[i];
				break;
			}
		}
		return ret;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		info.append("---[ " + this.name + " ]---").append("\n");
		for (int i = 0; i < this.index; i++) {
			info.append(this.books[i]).append("\n");
		}
		return info.toString();
	}
}
