package hu.qwaevisz.exception.checked;

public class TooLowException extends WrongValueException {

	private static final long serialVersionUID = 999647316836694261L;

	public TooLowException() {
		System.out.println("TooLowException instance created..");
	}

	public TooLowException(String message) {
		super(message);
		System.out.println("TooLowException instance created..");
	}

}
