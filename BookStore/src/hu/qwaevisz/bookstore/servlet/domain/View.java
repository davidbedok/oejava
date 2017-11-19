package hu.qwaevisz.bookstore.servlet.domain;

public enum View {

	LIST("list"),
	BOOK("book");

	private static final String EXTENSION = "jsp";
	private static final String EDIT_POSTFIX = "-edit";

	private final String page;

	private View(String page) {
		this.page = page;
	}

	public String getPage() {
		return this.buildPage(this.page);
	}

	public String getPage(boolean editFlag) {
		return editFlag ? this.buildPage(this.page + EDIT_POSTFIX) : this.getPage();
	}

	private String buildPage(String page) {
		return page + "." + EXTENSION;
	}

}
