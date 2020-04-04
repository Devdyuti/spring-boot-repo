package org.tutorial.hibernate.poc.autoddl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="employee")
@Table(name="tutorial.employee")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	@Column(updatable=false)
	private String name;
	@Column(name="email", unique=true, columnDefinition="varchar(64)")
	private String email;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Employee(String name, String email) {
		this.name = name;
		this.email = email;
	}
	public Employee() {
		super();
	}
	
	
	
	
}
