package org.tutorial.jpa.tuto.exception;

public class ApplicationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2819508283044416974L;
	
	private int errorCode;
	private String erroMessage;
	
	
	public ApplicationException() {}


	public ApplicationException(int errorCode, String erroMessage) {
		super(erroMessage);
		this.errorCode = errorCode;
		this.erroMessage = erroMessage;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	public String getErroMessage() {
		return erroMessage;
	}


	public void setErroMessage(String erroMessage) {
		this.erroMessage = erroMessage;
	}
	
	
	
	
	
}
