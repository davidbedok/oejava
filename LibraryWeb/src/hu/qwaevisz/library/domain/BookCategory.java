package hu.qwaevisz.library.domain;

public enum BookCategory {

	SCIFI("Sci-Fi"),
	LITERATURE("Literature"),
	HISTORICAL("Historical");

	private final String label;

	private BookCategory(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

}
