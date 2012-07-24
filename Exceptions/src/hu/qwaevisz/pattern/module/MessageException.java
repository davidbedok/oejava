package hu.qwaevisz.pattern.module;

import hu.qwaevisz.pattern.base.ModuleException;

public class MessageException extends ModuleException {

	private static final long serialVersionUID = 4010968889948169521L;

	public MessageException() {
		super();
	}

	public MessageException(MessageErrorCodes error) {
		super(error);
	}

	public MessageException(MessageErrorCodes error, String extension) {
		super(error);
		this.setMessageExtension(extension);
	}

	public MessageException(MessageErrorCodes error, Throwable t) {
		super(error, t);
	}

	public MessageException(String message) {
		super(message);
	}

	public MessageException(String message, Throwable t) {
		super(message, t);
	}

	public MessageException(Throwable t) {
		super(t);
	}

}
