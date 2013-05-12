package hu.zskf.library.book;

import hu.zskf.library.base.Book;
import hu.zskf.library.base.Language;
import hu.zskf.library.base.Publisher;

public class SciFiBook extends Book {

	private final String world;

	public SciFiBook(String title, int pageCount, Language language,
			Publisher publisher, int publisherYear, String world) {
		super(title, pageCount, language, publisher, publisherYear);
		this.world = world;
	}

	public String getWorld() {
		return this.world;
	}

	@Override
	public String toString() {
		return "SciFiBook " + this.world + super.toString();
	}

	@Override
	protected int borrowTime() {
		return 6;
	}

}
