package hu.zskf.library.book;

import hu.zskf.library.base.Book;
import hu.zskf.library.base.Language;
import hu.zskf.library.base.Publisher;

public class LiteratureBook extends Book {

	private final Period period;

	public LiteratureBook(String title, int pageCount, Language language,
			Publisher publisher, int publisherYear, Period period) {
		super(title, pageCount, language, publisher, publisherYear);
		this.period = period;
	}

	public Period getPeriod() {
		return this.period;
	}

	@Override
	public String toString() {
		return "LiteratureBook " + this.period + super.toString();
	}

	@Override
	protected int borrowTime() {
		return 3;
	}

}
