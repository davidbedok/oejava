package hu.zskf.library.book;

import hu.zskf.library.base.Book;
import hu.zskf.library.base.Language;
import hu.zskf.library.base.Publisher;

public class Encyclopedia extends Book {

	private final char startLetter;
	private final char endLetter;

	public Encyclopedia(String title, int pageCount, Language language,
			Publisher publisher, int publisherYear, char startLetter,
			char endLetter) {
		super(title, pageCount, language, publisher, publisherYear);
		this.startLetter = startLetter;
		this.endLetter = endLetter;
	}

	public char getStartLetter() {
		return this.startLetter;
	}

	public char getEndLetter() {
		return this.endLetter;
	}

	@Override
	public String toString() {
		return "Encyclopedia " + this.startLetter + "-" + this.endLetter
				+ super.toString();
	}

	@Override
	public String borrow(String name) {
		return name + " cannot borrow this book (" + this.getTitle() + ").";
	}

	@Override
	protected int borrowTime() {
		return 0;
	}

}
