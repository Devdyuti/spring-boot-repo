package org.test.rst.ws;

public class HelloBean {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return String.format("HelloBean [message%s=]", message);
	}
	
	public HelloBean(String message) {
		this.message=message;
	}
}
