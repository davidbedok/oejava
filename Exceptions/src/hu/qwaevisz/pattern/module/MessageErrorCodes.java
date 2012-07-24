package hu.qwaevisz.pattern.module;

import hu.qwaevisz.pattern.common.ErrorCode;

public enum MessageErrorCodes implements ErrorCode {

	M_GENERAL(2000,"Message general error."),
	M_BADFORMAT(2001,"Message bad format.");
	
	private int code;
	private String message;
	
	private MessageErrorCodes(int code, String message){
		this.code = code;
		this.message = message;
	}
	
	public static MessageErrorCodes getDefault() {
		return MessageErrorCodes.M_GENERAL;
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
	
	public static MessageErrorCodes fromCode(int code) {
		MessageErrorCodes ret = MessageErrorCodes.getDefault();
		for (MessageErrorCodes cr : MessageErrorCodes.values()) {
			if (cr.getCode() == code) {
				ret = cr;
			}
		}
		return ret;
	}
	
}
