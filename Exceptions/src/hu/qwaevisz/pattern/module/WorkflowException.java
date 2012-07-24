package hu.qwaevisz.pattern.module;

import hu.qwaevisz.pattern.base.ModuleException;

public class WorkflowException extends ModuleException {

	private static final long serialVersionUID = 4010968889948169521L;

	public WorkflowException() {
		super();
	}

	public WorkflowException(WorkflowErrorCodes error) {
		super(error);
	}

	public WorkflowException(WorkflowErrorCodes error, String extension) {
		super(error);
		this.setMessageExtension(extension);
	}

	public WorkflowException(WorkflowErrorCodes error, Throwable t) {
		super(error, t);
	}

	public WorkflowException(String message) {
		super(message);
	}

	public WorkflowException(String message, Throwable t) {
		super(message, t);
	}

	public WorkflowException(Throwable t) {
		super(t);
	}

}
