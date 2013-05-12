package hu.zskf.library.base;

public abstract class Book extends Object {

	private static final int MAX_AUTHORS = 5;
	private final String title;
	private final String[] authors;
	private int index;
	private final int pageCount;
	private final Language language;
	private final Publisher publisher;
	private final int publisherYear;

	public Book(String title, int pageCount, Language language,
			Publisher publisher, int publisherYear) {
		this.title = title;
		this.pageCount = pageCount;
		this.language = language;
		this.publisher = publisher;
		this.publisherYear = publisherYear;
		this.authors = new String[Book.MAX_AUTHORS];
		this.index = 0;
	}

	public String getTitle() {
		return this.title;
	}

	public void addAuthor(String name) {
		if (this.index < Book.MAX_AUTHORS) {
			this.authors[this.index++] = name;
		}
	}

	public String borrow(String name) {
		return name + " borrows this book (" + this.title + ") for "
				+ this.borrowTime() + " month(s).";
	}

	protected abstract int borrowTime();

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(50);
		info.append(" ");
		for (int i = 0; i < this.index; i++) {
			info.append(this.authors[i]).append(" ");
		}
		info.append(": ").append(this.title);
		info.append(" (page: " + this.pageCount + ", language: "
				+ this.language + ")");
		info.append(" - ").append(this.publisher)
				.append(" (" + this.publisherYear + ")");
		return info.toString();
	}

}
