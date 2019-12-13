package org.tutorial.hibernate.poc.orm.inheritance.table_per_concreteClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="apple")
@Table(name="tutorial.apple")
public class Apple extends Fruit{
	public Apple(int id, String name, String location, String subcast) {
		super(id, name, location);
		this.subcast=subcast;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4680822354887035802L;
	private String subcast;

	public String getSubcast() {
		return subcast;
	}

	public void setSubcast(String subcast) {
		this.subcast = subcast;
	}
	
	
}
