package hu.qwaevisz.exception.checked;

public class TooHighException extends WrongValueException {

	private static final long serialVersionUID = 5495238356541972957L;

	public TooHighException() {
		System.out.println("TooHighException instance created..");
	}

	public TooHighException(String message) {
		super(message);
		System.out.println("TooHighException instance created..");
	}

}
