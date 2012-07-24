package hu.qwaevisz.pattern.base;

public class BaseException extends Exception {

	private static final long serialVersionUID = -777069142309293821L;

	public BaseException() {
		super();
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public BaseException(Throwable throwable) {
		super(throwable);
	}

}
