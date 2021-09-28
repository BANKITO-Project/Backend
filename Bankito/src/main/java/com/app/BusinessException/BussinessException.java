package com.app.BusinessException;
@SuppressWarnings("serial")
public class BussinessException extends RuntimeException{
	public BussinessException() {
		super();
	}
	public BussinessException(String message) {
		super(message);
	}
	
}
