package org.tutorial.hibernate.poc.autoddl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="devdyuti")
@Table(name="tutorial.devdyuti")
class Devdyuti implements Serializable{

	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 498512822724477909L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String name;
	private int age;
	@Column(updatable= false)
	private String father;
	
	
	
	
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




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public String getFather() {
		return father;
	}




	public void setFather(String father) {
		this.father = father;
	}




	public Devdyuti(int id,String name, int age, String father) {
		super();
		this.id = id;
		this.name = name;
		this.age=age;
		this.father=father;
	}
	
	
	
	
	
	
}
