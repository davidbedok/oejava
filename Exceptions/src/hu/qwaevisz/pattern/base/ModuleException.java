package hu.qwaevisz.pattern.base;

import hu.qwaevisz.pattern.common.ErrorCode;

public class ModuleException extends BaseException {

	private static final long serialVersionUID = 1036187668632645539L;

	// message szoveget egesziti ki
	private String extension = "";
	private ErrorCode error;

	public ModuleException() {
		super();
	}

	// ismert hibaeset
	public ModuleException(ErrorCode error) {
		super(error.getMessage());
		this.error = error;
	}

	// ismert hibaeset + kisero kivetel
	public ModuleException(ErrorCode error, Throwable t) {
		super(error.getMessage(), t);
		this.error = error;
	}

	public ModuleException(String message) {
		super(message);
	}

	public ModuleException(String message, Throwable t) {
		super(message, t);
	}

	// eredeti kivetel
	public ModuleException(Throwable t) {
		super(t);
	}

	public ErrorCode getError() {
		return this.error;
	}

	@Override
	public String getLocalizedMessage() {
		return ((this.error != null) ? (this.error.getMessage() + this.extension) : (super.getLocalizedMessage() + this.extension));
	}

	@Override
	public String getMessage() {
		return ((this.error != null) ? (this.error.getMessage() + this.extension) : (super.getMessage() + this.extension));
	}

	public void setError(ErrorCode error) {
		this.error = error;
	}

	public void setMessageExtension(String extension) {
		this.extension = extension;
	}

}