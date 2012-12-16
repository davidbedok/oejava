package hu.qwaevisz.disney.exception;

public class InvalidDisneyFileException extends Exception {

	private static final long serialVersionUID = 7756408060630734951L;

	private final String invalidLine;

	public InvalidDisneyFileException(String invalidLine) {
		this(invalidLine, null);
	}

	public InvalidDisneyFileException(String invalidLine, String message) {
		super(message);
		this.invalidLine = invalidLine;
	}

	public String getInvalidLine() {
		return this.invalidLine;
	}

}
