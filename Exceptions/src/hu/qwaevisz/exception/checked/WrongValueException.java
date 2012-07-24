package hu.qwaevisz.exception.checked;

public class WrongValueException extends Exception {

	private static final long serialVersionUID = 4683814508018930169L;

	public WrongValueException() {
		System.out.println("WrongValueException instance created..");
	}

	public WrongValueException(String message) {
		super(message);
		System.out.println("WrongValueException instance created..");
	}

}
