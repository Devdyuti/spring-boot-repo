package org.tutorial.hibernate.poc.orm.inheritance.table_per_subclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="dog")
@Table(name="tutorial.dog")
public class Dog extends Animal{
	public Dog(int id, String name, int age, String bark) {
		super(id, name, age);
		this.bark=bark;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5449960813084455653L;
	private String bark;

	public String getBark() {
		return bark;
	}

	public void setBark(String bark) {
		this.bark = bark;
	}
	
	
}
