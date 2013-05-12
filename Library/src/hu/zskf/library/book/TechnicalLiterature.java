package hu.zskf.library.book;

import hu.zskf.library.base.Book;
import hu.zskf.library.base.Language;
import hu.zskf.library.base.Publisher;

public class TechnicalLiterature extends Book {

	private final String topic;

	public TechnicalLiterature(String title, int pageCount, Language language,
			Publisher publisher, int publisherYear, String topic) {
		super(title, pageCount, language, publisher, publisherYear);
		this.topic = topic;
	}

	public String getTopic() {
		return this.topic;
	}

	@Override
	public String toString() {
		return "TechnicalLiterature " + this.topic + super.toString();
	}

	@Override
	protected int borrowTime() {
		return 1;
	}

}
