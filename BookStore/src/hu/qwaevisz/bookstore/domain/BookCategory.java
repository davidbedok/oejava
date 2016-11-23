package hu.qwaevisz.bookstore.domain;

public enum BookCategory {

	HISTORICAL("Historical"),
	LITERATURE("Literature"),
	SCIFI("Sci-Fi"),
	PHILOSOPHY("Philosophy");

	private final String label;

	private BookCategory(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

}
