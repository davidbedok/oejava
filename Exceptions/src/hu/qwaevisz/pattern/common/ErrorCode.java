package hu.qwaevisz.pattern.common;

import java.io.Serializable;

public interface ErrorCode extends Serializable {
	
	public int getCode();
    public String getMessage();    
    
}
