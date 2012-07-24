package hu.qwaevisz.pattern.module;

import hu.qwaevisz.pattern.common.ErrorCode;

public enum WorkflowErrorCodes implements ErrorCode {

	WF_GENERAL(1000,"Workflow general error."),
	WF_CRITICAL(1001,"Workflow critical error.");
	
	private int code;
	private String message;
	
	private WorkflowErrorCodes(int code, String message){
		this.code = code;
		this.message = message;
	}
	
	public static WorkflowErrorCodes getDefault() {
		return WorkflowErrorCodes.WF_GENERAL;
	}

	@Override
	public String toString() {
		return "["+this.code+"] "+this.message;
	}		
	
	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	public static WorkflowErrorCodes fromCode(int code) {
		WorkflowErrorCodes ret = WorkflowErrorCodes.getDefault();
		for (WorkflowErrorCodes cr : WorkflowErrorCodes.values()) {
			if (cr.getCode() == code) {
				ret = cr;
			}
		}
		return ret;
	}
	
}
