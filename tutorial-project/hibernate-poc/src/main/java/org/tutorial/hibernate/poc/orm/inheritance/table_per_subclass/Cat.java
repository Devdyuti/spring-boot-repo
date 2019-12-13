package org.tutorial.hibernate.poc.orm.inheritance.table_per_subclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="cat")
@Table(name="tutorial.cat")
public class Cat extends Animal{
	public Cat(int id, String name, int age, String miyau) {
		super(id, name, age);
		this.miyau=miyau;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4354678133612797055L;
	private String miyau;

	public String getMiyau() {
		return miyau;
	}

	public void setMiyau(String miyau) {
		this.miyau = miyau;
	}
	
	
	
}
