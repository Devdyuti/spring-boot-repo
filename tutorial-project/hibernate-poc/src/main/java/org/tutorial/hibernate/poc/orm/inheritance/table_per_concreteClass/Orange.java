package org.tutorial.hibernate.poc.orm.inheritance.table_per_concreteClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="orange")
@Table(name="tutorial.orange")
public class Orange extends Fruit{
	public Orange(int id, String name, String location, String color) {
		super(id, name, location);
		this.color=color;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7256029074784524302L;
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
