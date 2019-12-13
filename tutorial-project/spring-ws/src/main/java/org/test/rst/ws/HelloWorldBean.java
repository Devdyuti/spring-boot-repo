package org.test.rst.ws;

public class HelloWorldBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public HelloWorldBean(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return String.format("HelloWorldBean [message]", name);
	}
}
